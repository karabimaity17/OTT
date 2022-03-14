package com.example.hotstar.Model;

import java.util.ArrayList;
import java.util.List;

public class AllViewModel {
    String id,name;
    int img;
    private List<LatestModel> latestModels=new ArrayList<>();

    public AllViewModel(String name, List<LatestModel> latestModels) {
        this.name = name;
        this.latestModels = latestModels;
    }

    public AllViewModel(String id, String name, int img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LatestModel> getLatestModels() {
        return latestModels;
    }
}
