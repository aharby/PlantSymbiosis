package com.davidriad.se.project.se_project_grp8;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBaseManager {
   static FirebaseDatabase databaseInstance =FirebaseDatabase.getInstance();
   static DatabaseReference plantNode = databaseInstance.getReference("/plants");


    public static void insert(PlantModel plant){
        plantNode.child(plant.getId()).setValue(plant);
    }

    public static void updateOnChange(final PlantsAdapter mAdapter, final ArrayList plantsList){

        final ArrayList<String> plantsNameList = new ArrayList<>();
        final Map<String, ArrayList<String>> plantAdjacencyList = new HashMap<>();

        plantNode.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
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

                    plantsNameList.add(plant.getName().toLowerCase());
                    /*
                    code for excluding avid plants should be here
                    for now the plant adjacency list built by only by looking to list that plant helps
                     */
                    plant.getHelps().replaceAll(String::toLowerCase);
                    plantAdjacencyList.put(plant.getName().toLowerCase(),plant.getHelps());
                }
                mAdapter.notifyDataSetChanged();
//
//                Suggest suggest = new Suggest(plantsNameList,plantAdjacencyList );
//                ArrayList<String> path = new ArrayList<>();
//                path =suggest.suggest("alliums","lettuce");
//                Log.d("path", path.toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }



    public static void remove(String id){
        plantNode.child(id).removeValue();
    }

    public static void update(PlantModel plant){
        plantNode.child(plant.getId()).setValue(plant);
    }

}
