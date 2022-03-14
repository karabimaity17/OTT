package com.example.hotstar.Model;

public class LatestModel {
    String id,name,type;
    int img,img2;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getImg() {
        return img;
    }

    public int getImg2() {
        return img2;
    }

    public LatestModel(String id, String name, String type, int img, int img2) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.img = img;
        this.img2 = img2;
    }
}
