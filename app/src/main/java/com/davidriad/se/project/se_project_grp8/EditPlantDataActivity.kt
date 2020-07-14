package com.davidriad.se.project.se_project_grp8

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*


class EditPlantDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_plant_data2)
        var plantDBRef: DatabaseReference? = null
        var plant: PlantModel


        val nameET = findViewById<EditText>(R.id.editTextName)
        val descriptionET = findViewById<EditText>(R.id.editTextDescription)
        val imageURLEditText = findViewById<EditText>(R.id.editTextImageUrl)
        val helpsRV = findViewById<RecyclerView>(R.id.helpsRV)
        val helpedByRV = findViewById<RecyclerView>(R.id.helbedByRV)
        val avoidRV = findViewById<RecyclerView>(R.id.avoidRV)
        val buttonAddHelp = findViewById<Button>(R.id.buttonAddHelp)
        val buttonAddHelpedBy = findViewById<Button>(R.id.buttonAddHelpedBy)
        val buttonAvoid = findViewById<Button>(R.id.buttonAddAvoid)
        val submitEdit = findViewById<Button>(R.id.submit)
        val spinnerHelps = findViewById<View>(R.id.spinner) as Spinner
        val spinnerHelpedBy = findViewById<View>(R.id.spinnerHelpedby) as Spinner
        val spinnerAvoid = findViewById<View>(R.id.spinnerAvoid) as Spinner


        val plantname = intent.getStringExtra("name")
        val plantdescription = intent.getStringExtra("description")
        val plantImage = intent.getStringExtra("image")
        val id = intent.getStringExtra("id")
        val helps = intent.getStringArrayListExtra("helps")
        val helpedBy = intent.getStringArrayListExtra("helpedBy")
        val avoid = intent.getStringArrayListExtra("avoid")
        val plantNames = intent.getStringArrayListExtra("plantNames")


        var helpsAdapter: EditHelpsPlantAdapter? = null
        var helpedByAdapter: EditHelpsPlantAdapter? = null
        var avoidAdapter: EditHelpsPlantAdapter? = null

        val mLayoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        helpsRV.itemAnimator = DefaultItemAnimator()
        helpsRV.layoutManager = mLayoutManager

        val mLayoutManagerHelpedBy = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        helpedByRV.itemAnimator = DefaultItemAnimator()
        helpedByRV.layoutManager = mLayoutManagerHelpedBy

        val mLayoutManagerAvoid = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        avoidRV.itemAnimator = DefaultItemAnimator()
        avoidRV.layoutManager = mLayoutManagerAvoid

        val plantDatabase = FirebaseDatabase.getInstance()
        plantDBRef = plantDatabase.getReference("/plants")


        //helps
        val helpArray = plantNames
        helpsAdapter = EditHelpsPlantAdapter(helps, this@EditPlantDataActivity, id)
        helpsRV.adapter = helpsAdapter
        for (help in helps) {
            if (plantNames.contains(help)) {
                helpArray.remove(help)
            }
        }

        val spinnerAdapterHelp = ArrayAdapter(this@EditPlantDataActivity, R.layout.support_simple_spinner_dropdown_item, helpArray)
        spinnerAdapterHelp.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinnerHelps.adapter = spinnerAdapterHelp


        //helped by
        val helpedByArray = plantNames
        helpedByAdapter = EditHelpsPlantAdapter(helpedBy, this@EditPlantDataActivity, id)
        helpedByRV.adapter = helpedByAdapter
        for (helpedBy in helpedBy) {
            if (plantNames.contains(helpedBy)) {
                helpedByArray.remove(helpedBy)
            }
        }

        val spinnerAdapterHelpedBy = ArrayAdapter(this@EditPlantDataActivity, R.layout.support_simple_spinner_dropdown_item, helpedByArray)
        spinnerAdapterHelpedBy.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinnerHelpedBy.adapter = spinnerAdapterHelpedBy


        //avoid
        val avoidArray = plantNames
        avoidAdapter = EditHelpsPlantAdapter(avoid, this@EditPlantDataActivity, id)
        avoidRV.adapter = avoidAdapter
        for (avoid in avoid) {
            if (plantNames.contains(avoid)) {
                avoidArray.remove(avoid)
            }
        }

        val spunnerAvoid = ArrayAdapter(this@EditPlantDataActivity, R.layout.support_simple_spinner_dropdown_item, avoidArray)
        spunnerAvoid.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinnerAvoid.adapter = spinnerAdapterHelpedBy






        nameET.setText(plantname)
        descriptionET.setText(plantdescription)
        imageURLEditText.setText(plantImage)

        val plants: MutableList<String> = ArrayList()
        var helpedByList = plants
        var avoids = plants

//        plantDBRef.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//
//
//                //retrieve all the names of plants
//                for (plant in dataSnapshot.children) {
//                    val name = plant.child("name").getValue(String::class.java)!!
//                    plants.add(name)
//                }
//
//                plant = dataSnapshot.child(id).getValue(PlantModel::class.java)!!
//                nameET.setText(plant.name)
//                descriptionET.setText(plant.description)
//                imageURLEditText.setText(plant.image)
//
//                //helps
//                helps = plants
//                if (plants.isNotEmpty()) {
//                    for (help in plant.helps) {
//                        helps.remove(help)
//                    }
//                }
//                helpsAdapter = EditHelpsPlantAdapter(plant.helps, this@EditPlantDataActivity, id)
//                helpsRV.adapter = helpsAdapter
//
//                val spinnerAdapter = ArrayAdapter(this@EditPlantDataActivity, R.layout.support_simple_spinner_dropdown_item, helps)
//                spinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
//                spinnerHelps.adapter = spinnerAdapter
//
//
//                //helped by
//                helpedByList = plants
//                if (plants.isNotEmpty()) {
//                    for (helpedBy in plant.helpedBy) {
//                        helpedByList.remove(helpedBy)
//                    }
//                }
//                helpedByAdapter = EditHelpsPlantAdapter(plant.helpedBy, this@EditPlantDataActivity, id)
//                helpedByRV.adapter = helpedByAdapter
//
//                val spinnerAdapterHelped = ArrayAdapter(this@EditPlantDataActivity, R.layout.support_simple_spinner_dropdown_item, helpedByList)
//                spinnerAdapterHelped.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
//                spinnerHelpedBy.adapter = spinnerAdapter
//
//
//                //avoid
//                avoids = plants
//                if (plants.isNotEmpty()) {
//                    for (avoid in plant.avoid) {
//                        avoids.remove(avoid)
//                    }
//                }
//                avoidAdapter = EditHelpsPlantAdapter(plant.avoid, this@EditPlantDataActivity, id)
//                avoidRV.adapter = avoidAdapter
//
//                val spinnerAdapterAvoid = ArrayAdapter(this@EditPlantDataActivity, R.layout.support_simple_spinner_dropdown_item, avoids)
//                spinnerAdapterAvoid.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
//                spinnerAvoid.adapter = spinnerAdapter
//
//
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {}
//        })


        buttonAddHelp.setOnClickListener {
            val newHelpPlant: String = spinnerHelps.selectedItem.toString()
            helps.add(newHelpPlant)
            helpsAdapter?.notifyDataSetChanged()
        }

//        plantDBRef.child(id).addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                plant = snapshot.getValue(PlantModel::class.java)!!
//                nameET.setText(plant.name)
//                descriptionET.setText(plant.description)
//                imageURLEditText.setText(plant.image)
//                if(!plants.isEmpty()){
//                    for(help in plant.helps)
//                    {
//                        plants.remove(help)
//                    }
//                    Toast.makeText(applicationContext,plants.toString(),Toast.LENGTH_LONG).show()
//                }
//                mAdapter = EditHelpsPlantAdapter(plant.helps, this@EditPlantDataActivity, id)
//                helpsRV.adapter = mAdapter
//
////                println(snapshot.value)
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {}
//        })


//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//        val search = findViewById<EditText>(R.id.search)
//        recyclerView.layoutManager = mLayoutManager
//        recyclerView.itemAnimator = DefaultItemAnimator()
//        mAdapter = EditHelpsPlantAdapter(plantsList, this)
//        recyclerView.adapter = mAdapter
//
//        val fab = findViewById<FloatingActionButton>(R.id.fab_feeds)
//        fab.setOnClickListener {
//            val intent = Intent(applicationContext, AddPlant::class.java)
//            startActivity(intent)
//        }


    }
}