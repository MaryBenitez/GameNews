package com.example.maris.gamenews.Class;

import java.util.ArrayList;

public class News {

    private int idnews;
    private String title;
    private String img;
    private String desc;
    private ArrayList<News> favorite;


    //constructor
    public News(int idnews, String title, String img, String desc, ArrayList<News> favorite) {
        this.idnews = idnews;
        this.title = title;
        this.img = img;
        this.desc = desc;
        this.favorite = favorite;
    }


    //Setters and Getters
    public int getIdnews() {
        return idnews;
    }
    public void setIdnews(int idnews) {
        this.idnews = idnews;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<News> getFavorite() {
        return favorite;
    }
    public void setFavorite(ArrayList<News> favorite) {
        this.favorite = favorite;
    }
}
