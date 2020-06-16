package com.davidriad.se.project.se_project_grp8;

public class PlantModel {
    private String id;
    private static String name;
    private static String description;
    private String image;

    public PlantModel() {
    }

    public PlantModel(String id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}