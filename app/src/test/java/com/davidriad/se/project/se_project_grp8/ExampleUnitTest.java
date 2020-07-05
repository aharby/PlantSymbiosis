package com.davidriad.se.project.se_project_grp8;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    //@Test
    //public void addition_isCorrect() {
      //  assertEquals(4, 2 + 2);
    //}

    @Test
    // def: create a plantModels ArrayList then do searching with the
    public void test_filter(){
        MainActivity mainActivity = new MainActivity();
        PlantModel plantModel = createPlant("test_id", "test_name");
        ArrayList<PlantModel> plantModels = new ArrayList<>();
        plantModels.add(plantModel);
        ArrayList<PlantModel> filteredList = mainActivity.returnArrayList("t", plantModels);

        for (PlantModel plant : filteredList){
            System.out.println(plant.getName());
        }
        assertArrayEquals(plantModels.toArray(), filteredList.toArray());
    }
    public PlantModel createPlant(String id, String name){
        PlantModel plantModel = new PlantModel(id, name);
        return plantModel;
    }
}