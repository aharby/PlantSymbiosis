package com.davidriad.se.project.se_project_grp8;

public class PlantModel {
    private String id;
    private String name;
    private String description;

    public PlantModel(){

    }
    public PlantModel(String id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;


}