package com.davidriad.se.project.se_project_grp8

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase


class EditPlantDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_plant_data2)
        val databaseInstance = FirebaseDatabase.getInstance()
        val plantNode = databaseInstance.getReference("/plants")
        val nameET = findViewById<EditText>(R.id.editTextName)
        val descriptionET = findViewById<EditText>(R.id.editTextDescription)
        val imageURLEditText = findViewById<EditText>(R.id.editTextImageUrl)
        val submitEdit = findViewById<Button>(R.id.submit)

        val plantname = intent.getStringExtra("name")
        val plantdescription = intent.getStringExtra("description")
        val plantImage = intent.getStringExtra("image")
        val id = intent.getStringExtra("id")
        val helps = intent.getStringArrayListExtra("helps")
        val helpedBy = intent.getStringArrayListExtra("helpedBy")
        val avoids = intent.getStringArrayListExtra("avoid")
        val plantNames = intent.getStringArrayListExtra("plantNames")


        nameET.setText(plantname)
        descriptionET.setText(plantdescription)
        imageURLEditText.setText(plantImage)



        submitEdit.setOnClickListener {
            var name  = nameET.text.toString()
            var desc = descriptionET.text.toString()
            var image = imageURLEditText.text.toString()
            var plant = PlantModel(id, name, desc, image, helps, helpedBy, avoids)
            DataBaseManager.update(plant)
        }


    }


}
