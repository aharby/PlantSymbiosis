package com.davidriad.se.project.se_project_grp8;

import java.util.ArrayList;

public class PlantModel {
    private String id;
    private String name;
    private String description;
    private ArrayList<String> helps;
    private ArrayList<String> helpedBy;
    private ArrayList<String> avoid;

    public ArrayList<String> getAvoid() {
        return avoid;
    }

    public void setAvoid(ArrayList<String> avoid) {
        this.avoid = avoid;
    }

    public ArrayList<String> getHelpedBy() {
        return helpedBy;
    }

    public void setHelpedBy(ArrayList<String> helpedBy) {
        this.helpedBy = helpedBy;
    }

    public ArrayList<String> getHelps() {
        return helps;
    }

    public void setHelps(ArrayList<String> helps) {
        this.helps = helps;
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

    private String image;


}