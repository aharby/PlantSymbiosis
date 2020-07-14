package com.davidriad.se.project.se_project_grp8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Content extends AppCompatActivity {
    TextView nameTv, descriptionTv;
    ImageView backArrow, details_image;
    TabLayout tabLayout;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
//        nameTv = (TextView) findViewById(R.id.name);
        backArrow = (ImageView) findViewById(R.id.backArrow);
        details_image = (ImageView) findViewById(R.id.details_plant_image);


        Toolbar mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        TextView textView = (TextView) mToolbar.findViewById(R.id.plantName);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String plantname = getIntent().getStringExtra("name");
        String plantdescription = getIntent().getStringExtra("description");
        String plantImage = getIntent().getStringExtra("image");
        id = getIntent().getStringExtra("id");
        Glide.with(this)
                .load(plantImage)
                .centerCrop()
                .into(details_image);
        ArrayList<String> helps = getIntent().getStringArrayListExtra("helps");
        ArrayList<String> helpedBy = getIntent().getStringArrayListExtra("helpedBy");
        ArrayList<String> avoid = getIntent().getStringArrayListExtra("avoid");
        ArrayList<String> plantNames = getIntent().getStringArrayListExtra("plantNames");

        textView.setText(plantname);

        //helps recycler view
        RecyclerView helpsRecyclerView = findViewById(R.id.rvHelps);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        helpsRecyclerView.setLayoutManager(mLayoutManager);
        helpsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        HelpsAdapter helpsAdapter = new HelpsAdapter(helps, this);
        helpsRecyclerView.setAdapter(helpsAdapter);

        //helped by recycler view
        RecyclerView helpedByRecycler = findViewById(R.id.rvHelpedBy);
        LinearLayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        helpedByRecycler.setLayoutManager(mLayoutManager1);
        helpedByRecycler.setItemAnimator(new DefaultItemAnimator());
        HelpedByAdapter helpedByAdapter = new HelpedByAdapter(helpedBy, this);
        helpedByRecycler.setAdapter(helpedByAdapter);

        //avoid recycler view
        RecyclerView avoidRecycler = findViewById(R.id.rvAvoid);
        LinearLayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        avoidRecycler.setLayoutManager(mLayoutManager2);
        avoidRecycler.setItemAnimator(new DefaultItemAnimator());
        AvoidAdapter avoidAdapter = new AvoidAdapter(avoid, this);
        avoidRecycler.setAdapter(avoidAdapter);

        //switch to edit activity

        ImageButton ib1 = (ImageButton) findViewById(R.id.edit);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditPlantDataActivity();
                Toast.makeText(Content.this, "In one sec you´ll be able to edit", Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton ib2 = (ImageButton) findViewById(R.id.delete);
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseManager.remove(id);
                Toast.makeText(Content.this, "Successful deletion", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Content.this, MainActivity.class);
                startActivity(intent);
            }

        });

        ImageButton editPlantButton = (ImageButton) findViewById(R.id.edit);
        editPlantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DataBaseManager.remove(id);
//                Toast.makeText(Content.this, "Successful deletion", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Content.this, EditPlantDataActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("name", plantname);
                intent.putExtra("description", plantdescription);
                intent.putExtra("image", plantImage);
                intent.putStringArrayListExtra("helps", helps);
                intent.putStringArrayListExtra("helpedBy", helpedBy);
                intent.putStringArrayListExtra("avoid", avoid);
                intent.putStringArrayListExtra("plantNames",plantNames);

                startActivity(intent);
            }

        });
    }

    public void openEditPlantDataActivity() {
        Intent intent = new Intent(Content.this, EditPlantDataActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);

    }
}


