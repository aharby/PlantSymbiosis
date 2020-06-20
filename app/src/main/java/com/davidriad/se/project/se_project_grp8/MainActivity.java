package com.davidriad.se.project.se_project_grp8;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    DatabaseReference plantDBRef;

    private ArrayList<PlantModel> plantsList = new ArrayList<>();
    private PlantsAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase plantDatabase = FirebaseDatabase.getInstance();
         plantDBRef = plantDatabase.getReference("/plants");


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        EditText search = findViewById(R.id.search);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new PlantsAdapter(plantsList,this);
        recyclerView.setAdapter(mAdapter);
        preparePlantData();


        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });
    }

    private void filter(String text) {
        ArrayList<PlantModel> filteredList = new ArrayList<> ();
        for (PlantModel plant : plantsList) {
            if ((plant.getName().toLowerCase())
                    .contains(text.toLowerCase())) {
                filteredList.add(plant);
            }
        }
        mAdapter.filterList(filteredList);
    }


    private void preparePlantData() {


        plantDBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {
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


}