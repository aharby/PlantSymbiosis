package com.davidriad.se.project.se_project_grp8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class editPlantDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_plant_data2)
        val id = intent.getStringExtra("id")
       // DataBaseManager().update(id);
    }
}