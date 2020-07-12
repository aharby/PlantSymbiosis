package com.davidriad.se.project.se_project_grp8;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static com.davidriad.se.project.se_project_grp8.DataBaseManager.suggestInstance;

public class SuggestActivity extends AppCompatActivity {

    Button buttonSuggest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);

        buttonSuggest = (Button) findViewById(R.id.buttonSuggest);
        buttonSuggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                here your need to get two plants names for the suggestion; then pass them to suggest(); that witll return the pass
                 */
               ArrayList<String>  path = DataBaseManager.suggestInstance.suggest("carrots","lettuce");

               if(!path.isEmpty()){
                Toast.makeText(getApplicationContext(), path.toString(), Toast.LENGTH_LONG).show();
            }
            else {
                /*
                no path found the two plants
                just show the list of plants that helps plant1
                 */
               }
            }
        });
    }
}