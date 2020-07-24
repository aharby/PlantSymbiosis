package com.davidriad.se.project.se_project_grp8;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static com.davidriad.se.project.se_project_grp8.DataBaseManager.suggestInstance;

public class SuggestActivity extends AppCompatActivity {

    Button buttonSuggest;
    EditText plant1EditText, plant2EditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);
        plant1EditText = (EditText) findViewById(R.id.editTextPlant1);
        plant2EditText = (EditText) findViewById(R.id.editTextPlant2);

        buttonSuggest = (Button) findViewById(R.id.buttonSuggest);
        buttonSuggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                here your need to get two plants names for the suggestion; then pass them to suggest(); that will return the path
                 */
                String name1 = plant1EditText.getText().toString();
                String name2 = plant2EditText.getText().toString();

                boolean validNames = suggestInstance.plantsNameList.contains(name1.toLowerCase())
                        && suggestInstance.plantsNameList.contains(name2.toLowerCase());
                if (validNames) {
                    ArrayList<String>  path = suggestInstance.suggest(name1,name2);

                    if(!path.isEmpty()){
                        Toast.makeText(getApplicationContext(), path.toString(), Toast.LENGTH_LONG).show(); }
                    else {
                        Toast.makeText(getApplicationContext(),"no path found for more information check plant "+ name1+" content", Toast.LENGTH_LONG).show(); }
                }
                else
                    Toast.makeText(getApplicationContext(), "please enter names that are listed in the main screen", Toast.LENGTH_LONG).show();
            }
        });
    }
}