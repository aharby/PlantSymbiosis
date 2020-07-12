package com.davidriad.se.project.se_project_grp8;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<PlantModel> plantsList = new ArrayList<>();
    private PlantsAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        EditText search = findViewById(R.id.search);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new PlantsAdapter(plantsList,this);
        recyclerView.setAdapter(mAdapter);
        DataBaseManager.updateOnChange(mAdapter, plantsList);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab_feeds);
        FloatingActionButton fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        FloatingActionButton fabSuggest = (FloatingActionButton) findViewById(R.id.fabSuggest);

        fab.setOnClickListener(new View.OnClickListener() {
            boolean isFABOpen = false;
            @Override
            public void onClick(View v) {
                if(!isFABOpen){
                    isFABOpen=true;
                    fabAdd.animate().translationY(-getResources().getDimension(R.dimen.standard_65));
                    fabSuggest.animate().translationY(-getResources().getDimension(R.dimen.standard_125));

                }else{
                    isFABOpen = false;
                    fabAdd.animate().translationY(0);
                    fabSuggest.animate().translationY(0);
                }

            }
        });

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddPlant.class);
                startActivity(intent);
            }
        });

        fabSuggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SuggestActivity.class);
                startActivity(intent);
            }
        });
    }

    private void filter(String text) {
        ArrayList<PlantModel> filteredList = new ArrayList<> ();
        for (PlantModel plant : plantsList) {
            if ((plant.getName().toLowerCase())
                    .contains(text.toLowerCase())) {
                filteredList.add(plant);
            }
        }
        mAdapter.filterList(filteredList);
    }

}