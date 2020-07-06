package com.davidriad.se.project.se_project_grp8;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddPlantTest {

    AddPlant addPlant = mock(AddPlant.class);

    MainActivity main = new MainActivity();
    Context context = main.getApplicationContext();



    DatabaseReference localNode = main.plantDBRef;
    DataSnapshot dataSnapshot;

    @Before
    public  void beforeMethod(){

    }

    @Test
    public void testAddPlant(){


        PlantModel mockPlant = mock(PlantModel.class);
        addPlant.addPlant(mockPlant);

        localNode.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Getting the string value of that node
                PlantModel plant =  dataSnapshot.getValue(PlantModel.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        assertEquals(mockPlant, localNode.child(mockPlant.getId()).getRef());
    }

}
