package com.davidriad.se.project.se_project_grp8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Content extends AppCompatActivity {
    TextView nameTv, descriptionTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
//        nameTv = (TextView) findViewById(R.id.name);
        descriptionTv = (TextView) findViewById(R.id.description);

        String plantname = getIntent().getStringExtra("name");
        String plantdescription = getIntent().getStringExtra("description");

//        nameTv.setText(plantname.toString());
        descriptionTv.setText(plantdescription);
    }
}