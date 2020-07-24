package com.davidriad.se.project.se_project_grp8;

import java.util.ArrayList;

public class PlantModel {
    private String id;
    private String name;
    private String description;
    private String image;
    private ArrayList<String> helps;
    private ArrayList<String> helpedBy;
    private ArrayList<String> avoid;

    public PlantModel() {
    }
    public ArrayList<String> getHelps() {
        return helps;
    }

    public void setHelps(ArrayList<String> helps) {
        this.helps = helps;
    }

    public ArrayList<String> getHelpedBy() {
        return helpedBy;
    }

    public void setHelpedBy(ArrayList<String> helpedBy) {
        this.helpedBy = helpedBy;
    }

    public ArrayList<String> getAvoid() {
        return avoid;
    }

    public void setAvoid(ArrayList<String> avoid) {
        this.avoid = avoid;
    }

    public PlantModel(String id, String name, String description, String image,ArrayList<String>helps,ArrayList<String> helpedBy,ArrayList<String> avoid) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.helps=helps;
        this.helpedBy=helpedBy;
        this.avoid=avoid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



}