package com.davidriad.se.project.se_project_grp8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPlant extends AppCompatActivity {

    Button addButton;
    EditText plantNameEditText, plantIdEditText;
    FirebaseDatabase databaseInstance;
    DatabaseReference plantNode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        plantIdEditText = (EditText) findViewById(R.id.editTextId);
        plantNameEditText = (EditText) findViewById(R.id.editTextName);
        addButton = (Button) findViewById(R.id.button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"you have added a plant", Toast.LENGTH_LONG).show();
            }
        });

    }
}

