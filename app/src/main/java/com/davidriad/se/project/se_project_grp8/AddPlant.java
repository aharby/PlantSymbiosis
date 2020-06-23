package com.davidriad.se.project.se_project_grp8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;

public class AddPlant extends AppCompatActivity {

    Button addButton;
    EditText plantNameEditText, plantDescriptionEditText, plantImageUrlEditText;
    FirebaseDatabase databaseInstance;
    DatabaseReference plantNode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        plantNameEditText = (EditText) findViewById(R.id.editTextName);
        plantDescriptionEditText = (EditText) findViewById(R.id.editTextDescription);
        plantImageUrlEditText = (EditText) findViewById(R.id.editTextImageUrl);
        addButton = (Button) findViewById(R.id.button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = plantNameEditText.getText().toString();
                String description = plantDescriptionEditText.getText().toString();
                String image = plantImageUrlEditText.getText().toString();

                String id = String.valueOf(UUID.randomUUID());
                ArrayList<String> helpsAray = new ArrayList<String>();
                helpsAray.add("");
                ArrayList<String> helpbedByArray = new ArrayList<String>();
                helpbedByArray.add("");
                ArrayList<String> avoidArray = new ArrayList<String>();
                avoidArray.add("");
                PlantModel plant = new PlantModel(id, name, description, image, helpsAray,helpbedByArray,avoidArray);

                databaseInstance = FirebaseDatabase.getInstance();
                plantNode = databaseInstance.getReference("/plants");
                plantNode.child(id).setValue(plant);

                Toast.makeText(getApplicationContext(), "you have added a plant", Toast.LENGTH_LONG).show();
            }
        });

    }
}

