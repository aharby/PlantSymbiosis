package com.davidriad.se.project.se_project_grp8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPlant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        final Button button = findViewById(R.id.button);
        final TextView textViewPlantID = findViewById(R.id.editTextTextPersonName);
        final TextView textViewPlantName = findViewById(R.id.editTextTextPersonName2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plantID = (String) textViewPlantID.getText();
                String plantName = (String) textViewPlantName.getText();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference("/plants");

                PlantModel plant = new PlantModel(plantID, plantName, "description");

                databaseReference.setValue(plant);
            }
        });
    }
}