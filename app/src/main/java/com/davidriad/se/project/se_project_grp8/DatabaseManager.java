package com.davidriad.se.project.se_project_grp8;

import android.provider.ContactsContract;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseManager {
    private FirebaseDatabase plantDatabase;
    private DatabaseReference plantDBref;
    private PlantsAdapter mAdapter;

    public DatabaseManager(){

    }
    // there is an error in PlantsAdapter, comment this out when PlantsAdapter is fixed
    /*
    public DatabaseManager(PlantsAdapter mAdapter){
        this.mAdapter = mAdapter;
    }
    */
    public void getReference(){
        plantDatabase = FirebaseDatabase.getInstance();
        plantDBref = plantDatabase.getReference("/plants");
    }
    public void addToDB(String plantID, String plantName, String description, String imageURL){
        PlantModel plant = new PlantModel(plantID, plantName, description, imageURL);
        plantDBref.child("/plants").child(plantID).setValue(plant);
    }
    // read all and return on the main screen
    public void readAllFromDB(){

    }
    // read a single one to return for a specific plant(e.g. tomato)
    public void readOneFromDB(){

    }
}
