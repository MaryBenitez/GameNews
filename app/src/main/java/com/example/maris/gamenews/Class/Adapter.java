package com.example.maris.gamenews.Class;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maris.gamenews.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder>{

    private Context context;
    private ArrayList<User> news;

    public Adapter(ArrayList<User> news) {
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_news,parent,false);

        return new AdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView foto;
        ImageView foto2;
        ImageView foto3;
        TextView new1;
        TextView new2;
        TextView new3;

        public AdapterViewHolder(View itemView){
            super(itemView);

            cardView=itemView.findViewById(R.id.card_view);
            foto=itemView.findViewById(R.id.lol);
            foto2=itemView.findViewById(R.id.csgo);
            foto3=itemView.findViewById(R.id.dota);
            new1=itemView.findViewById(R.id.news);
            new2=itemView.findViewById(R.id.news2);
            new3=itemView.findViewById(R.id.news3);

        }

    }
}
