package com.example.maris.gamenews.MainActivities.Data.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("token")
    @Expose
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    //Aqui se recibe el tocken de la API
    @Override
    public String toString() {
        return "Request{" +
                "token='" + token + '\'' +
                '}';
    }

    //Obtener la lista de noticias
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("game")
    @Expose
    private String game;
    @SerializedName("coverImage")
    @Expose
    private String coverImage;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("description")
    @Expose
    private String description;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public String getGame() {
        return game;
    }
    public void setGame(String game) {
        this.game = game;
    }

    public String getCoverImage() {
        return coverImage;
    }
    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getV() {
        return v;
    }
    public void setV(Integer v) {
        this.v = v;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String toStringNews() {
        return "Request{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", game='" + game + '\'' +
                ", coverImage='" + coverImage + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", v=" + v +
                ", description='" + description + '\'' +
                '}';
    }

}
