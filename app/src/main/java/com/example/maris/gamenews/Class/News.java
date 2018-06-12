package com.example.maris.gamenews.Class;

import java.util.ArrayList;

public class News {

    private String title;
    private ArrayList<News> favorite;
    private String img;

    public News(String img, String title, ArrayList<News> favorite) {
        this.img = img;
        this.title = title;
        this.favorite = favorite;
    }

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<News> getFavorite() {
        return favorite;
    }
    public void setFavorite(ArrayList<News> favorite) {
        this.favorite = favorite;
    }

}
