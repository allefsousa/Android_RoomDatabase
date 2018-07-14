package com.example.allef.next.movilenextaula1_room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * classe que vai cuidar das mudanças de estrutura do Banco de dados
 */
@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    private static WordRoomDatabase instance;
    public abstract WordDao wordDao();

    static WordRoomDatabase getDatabase(final Context context){
        if (instance == null){
            synchronized (WordRoomDatabase.class){
                if (instance == null){
                    // cria o banco
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            WordRoomDatabase.class,
                            "word_database")
                            .build();
                }
            }
        }
        return instance;
    }
}
