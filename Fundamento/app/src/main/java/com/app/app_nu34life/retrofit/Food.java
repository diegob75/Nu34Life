package com.app.app_nu34life.retrofit;

public class Food {

    private Integer id;
    private String name;

    private String image;

    private NutrFact nutrFact;
    private  int createdBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NutrFact getNutrFact() {
        return nutrFact;
    }

    public void setNutrFact(NutrFact nutrFact) {
        this.nutrFact = nutrFact;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
