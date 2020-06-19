package com.davidriad.se.project.se_project_grp8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddPlant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        final Button button = findViewById(R.id.button2);
        final TextView textViewPlantID = (TextView) findViewById(R.id.plantIDText);
        final TextView textViewPlantName = (TextView) findViewById(R.id.plantNameText);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String plantID = (String) textViewPlantID.getText();
                String plantName = (String) textViewPlantName.getText();

                DatabaseManager dbManager = new DatabaseManager();

                dbManager.getReference();
                dbManager.addToDB(plantID, plantName, "description", "imageURL");
            }
        });
    }
}