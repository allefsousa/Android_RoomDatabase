package com.example.allef.next.movilenextaula1_room;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewolder> {


    public class WordViewolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;
        public WordViewolder(@NonNull View itemView) {
            super(itemView);
            this.wordItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mLayoutInflater;
    private List<Word> mWords;

    public WordListAdapter(Context context){
        mLayoutInflater = LayoutInflater.from(context);


    }

    void setWords(List<Word> Words){
        mWords = Words;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public WordViewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.recyclerview_item,parent,false);
        return new WordViewolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull WordViewolder holder, int position) {

        if (mWords != null){
            Word current = mWords.get(position);
            holder.wordItemView.setText(current.getWord());
        }else {
            holder.wordItemView.setText("No Word");
        }
    }

    @Override
    public int getItemCount() {
        return (mWords!= null) ? mWords.size():0;
    }
}
