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

    Button addPlant,buttonAdd,buttonAddHelped,buttonAvoid;
    EditText plantNameEditText, plantDescriptionEditText, plantImageUrlEditText, helps, helpedBy, avoidET;
    FirebaseDatabase databaseInstance;
    DatabaseReference plantNode;

    ArrayList<String> helpsAray = new ArrayList<String>();
    ArrayList<String> helpedByArray = new ArrayList<String>();
    ArrayList<String> avoidArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        plantNameEditText = (EditText) findViewById(R.id.editTextName);
        plantDescriptionEditText = (EditText) findViewById(R.id.editTextDescription);
        plantImageUrlEditText = (EditText) findViewById(R.id.editTextImageUrl);
        addPlant = (Button) findViewById(R.id.button);
        helps = (EditText) findViewById(R.id.helps);
        helpedBy = (EditText) findViewById(R.id.helpedBy);
        avoidET = (EditText) findViewById(R.id.avoid);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAddHelped = (Button) findViewById(R.id.buttonAddHelped);
        buttonAvoid = (Button) findViewById(R.id.buttonAvoid);

        //help
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!helps.getText().equals("")){
                    helpsAray.add(helps.getText().toString());
                }
                helps.setText("");
            }
        });

        //helped by
        buttonAddHelped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!helpedBy.getText().equals("")){
                    helpedByArray.add(helpedBy.getText().toString());
                }
                helpedBy.setText("");
            }
        });

        //avoid
        buttonAvoid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!avoidET.getText().equals("")){
                    avoidArray.add(avoidET.getText().toString());
                }
                avoidET.setText("");
            }
        });

        addPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(helpsAray.size() != 0 && helpedByArray.size() != 0 && avoidArray.size() !=0 ){
                    String name = plantNameEditText.getText().toString();
                    String description = plantDescriptionEditText.getText().toString();
                    String image = plantImageUrlEditText.getText().toString();

                    String id = String.valueOf(UUID.randomUUID());
                    PlantModel plant = new PlantModel(id, name, description, image, helpsAray, helpedByArray, avoidArray);

                    databaseInstance = FirebaseDatabase.getInstance();
                    plantNode = databaseInstance.getReference("/plants");
                    plantNode.child(id).setValue(plant);

                    Toast.makeText(getApplicationContext(), "you have added a plant", Toast.LENGTH_LONG).show();
                    plantNameEditText.setText("");
                    plantDescriptionEditText.setText("");
                    plantImageUrlEditText.setText("");
                    helpsAray.clear();
                    helpedByArray.clear();
                    avoidArray.clear();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Make sure you entered data to all fields", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

