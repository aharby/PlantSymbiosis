package com.davidriad.se.project.se_project_grp8;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class PlantsAdapter extends RecyclerView.Adapter<PlantsAdapter.MyViewHolder> {
    private Activity context;
    private List<PlantModel> plantsList;
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            description = view.findViewById(R.id.descriotion);
        }
    }
    public PlantsAdapter(List<PlantModel> plantsList, Context contex) {

        this.plantsList = plantsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.planet_item, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PlantModel plant = plantsList.get(position);
        holder.name.setText(plant.getName());
        holder.description.setText(plant.getDescription());
    }
    @Override
    public int getItemCount() {
        return plantsList.size();
    }
}