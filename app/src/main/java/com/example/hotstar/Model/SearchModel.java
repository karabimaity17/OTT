package com.example.hotstar.Model;

public class SearchModel {
    String id,name,type;
    int image;

    public String getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public SearchModel(String id, int image, String name, String type) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.type = type;

    }


    @Override
    public String toString() {
        return  name;
    }
}
