package com.example.hotstar.Model;

public class GenreModel {
    String id,name;
    int image;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public GenreModel(String id, String name, int image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
}
