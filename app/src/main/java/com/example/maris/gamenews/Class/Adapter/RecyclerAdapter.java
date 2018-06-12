package com.example.maris.gamenews.Class.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maris.gamenews.Class.News;
import com.example.maris.gamenews.Class.User;
import com.example.maris.gamenews.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AdapterViewHolder> {

    private Context context;
    private List<News> data;

    //constructor
    public RecyclerAdapter(Context context,List<News> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.news,parent,false);

        return new AdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {

        holder.title_news.setText(data.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder{

        ImageView img_game;
        TextView title_news;
        ImageButton btnimg;

        public AdapterViewHolder(View itemView){
            super(itemView);

            img_game = itemView.findViewById(R.id.piccv);
            title_news = itemView.findViewById(R.id.newscv);
            btnimg = itemView.findViewById(R.id.btn_favoritocv);

        }

    }

}
