package com.davidriad.se.project.se_project_grp8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Content extends AppCompatActivity {
    TextView name,description;
    String plantname, plantdescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        name.findViewById(R.id.name);
        description.findViewById(R.id.description);
        plantname = getIntent().getStringExtra("name");
        plantdescription = getIntent().getStringExtra("description");
        name.setText(plantname);
        description.setText(plantdescription);


    }
}