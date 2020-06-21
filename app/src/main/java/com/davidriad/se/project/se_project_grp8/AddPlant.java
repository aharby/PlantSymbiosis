package com.davidriad.se.project.se_project_grp8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPlant extends AppCompatActivity {

    Button btnAdd;
    TextView textViewPlantName;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        databaseReference = FirebaseDatabase.getInstance().getReference("plants");

        textViewPlantName = (TextView) findViewById(R.id.editTextPlantName);
        btnAdd = (Button) findViewById(R.id.buttonAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPlant();
            }
        });
    }
    private void addPlant(){
        String plantName = textViewPlantName.getText().toString();

        if(!TextUtils.isEmpty(plantName)){
            // get a unique ID
            String plantID = databaseReference.push().getKey();

            PlantModel plant = new PlantModel(plantID,plantName, "DescriptionTest");

            databaseReference.child(plantID).setValue(plant);

            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Please enter a plant name", Toast.LENGTH_LONG).show();
        }
    }
}