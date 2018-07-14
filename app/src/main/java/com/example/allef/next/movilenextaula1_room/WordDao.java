package com.example.allef.next.movilenextaula1_room;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Word word);



    @Query("DELETE FROM word_table") // Query personalizada
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY Word ASC") //Query personalizada
    LiveData <List<Word>> getAllWords();


}
