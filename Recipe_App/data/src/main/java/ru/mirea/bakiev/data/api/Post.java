package ru.mirea.bakiev.data.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("img")
    @Expose
    private String img;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String desc) {
        this.desc = desc;
    }

    public String getDescription() {
        return desc;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }
}
