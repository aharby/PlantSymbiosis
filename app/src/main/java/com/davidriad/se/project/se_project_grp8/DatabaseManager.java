package com.davidriad.se.project.se_project_grp8;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseManager {
    private FirebaseDatabase plantDatabase;
    private DatabaseReference plantDBref;

    public void getReference(){
        plantDatabase = FirebaseDatabase.getInstance();
        plantDBref = plantDatabase.getReference("/plants");
    }

    public void addToDB(String plantID, String plantName, String plantDescription){
        PlantModel plant = new PlantModel();
        plant.setId(plantID);
        plant.setName(plantName);
        plant.setDescription(plantDescription);

        //
        plantDBref.child("/plants").child(plant.getId()).setValue(plant.getName(),plant.getDescription());

    }

}
