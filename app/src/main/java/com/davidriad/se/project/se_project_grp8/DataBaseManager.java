package com.davidriad.se.project.se_project_grp8;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DataBaseManager {
    FirebaseDatabase databaseInstance =FirebaseDatabase.getInstance();
    DatabaseReference plantNode = databaseInstance.getReference("/plants");


    public void insert(PlantModel plant){
        plantNode.child(plant.getId()).setValue(plant);
    }

    public void viewData(final PlantsAdapter mAdapter, final ArrayList plantsList){

        plantNode.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //clearing the previous plant list
                plantsList.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting plant
                    PlantModel plant =  postSnapshot.getValue(PlantModel.class);
                    //adding plant to the list
                    plantsList.add(plant);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }


    public void remove(PlantModel plant){
        plantNode.child(plant.getId()).removeValue();
    }

    public void update(PlantModel plant){
        plantNode.child(plant.getId()).setValue(plant);
    }

}
