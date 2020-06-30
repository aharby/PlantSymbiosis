package com.davidriad.se.project.se_project_grp8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Content extends AppCompatActivity {
    TextView nameTv, descriptionTv;
    ImageView backArrow, details_image;
    TabLayout tabLayout;
    Button buttonDelete;
    DataBaseManager dBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
//        nameTv = (TextView) findViewById(R.id.name);
        dBManager = new DataBaseManager();
        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        backArrow = (ImageView) findViewById(R.id.backArrow);
        details_image = (ImageView) findViewById(R.id.details_plant_image);


        Toolbar mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        TextView textView = (TextView)   mToolbar.findViewById(R.id.plantName);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plantId = getIntent().getStringExtra("id");
                dBManager.remove(plantId);
            }
        });
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String plantName = getIntent().getStringExtra("name");
        String plantdescription = getIntent().getStringExtra("description");
        String plantImage = getIntent().getStringExtra("image");
        Glide.with(this)
                .load(plantImage)
                .centerCrop()
                .into(details_image);
        ArrayList<String> helps = getIntent().getStringArrayListExtra("helps");
        ArrayList<String> helpedBy = getIntent().getStringArrayListExtra("helpedBy");
        ArrayList<String> avoid = getIntent().getStringArrayListExtra("avoid");
        textView.setText(plantName);

        //helps recycler view
        RecyclerView helpsRecyclerView = findViewById(R.id.rvHelps);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        helpsRecyclerView.setLayoutManager(mLayoutManager);
        helpsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        HelpsAdapter helpsAdapter = new HelpsAdapter(helps,this);
        helpsRecyclerView.setAdapter(helpsAdapter);

        //helped by recycler view
        RecyclerView helpedByRecycler = findViewById(R.id.rvHelpedBy);
        LinearLayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        helpedByRecycler.setLayoutManager(mLayoutManager1);
        helpedByRecycler.setItemAnimator(new DefaultItemAnimator());
        HelpedByAdapter helpedByAdapter = new HelpedByAdapter(helpedBy,this);
        helpedByRecycler.setAdapter(helpedByAdapter);

        //avoid recycler view
        RecyclerView avoidRecycler = findViewById(R.id.rvAvoid);
        LinearLayoutManager mLayoutManager2= new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        avoidRecycler.setLayoutManager(mLayoutManager2);
        avoidRecycler.setItemAnimator(new DefaultItemAnimator());
        AvoidAdapter avoidAdapter = new AvoidAdapter(avoid,this);
        avoidRecycler.setAdapter(avoidAdapter);
    }


}