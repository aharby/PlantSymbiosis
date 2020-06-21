package com.davidriad.se.project.se_project_grp8;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class PlantsAdapter extends RecyclerView.Adapter<PlantsAdapter.MyViewHolder> {
    private Context context;
    private List<PlantModel> plantsList;

    public void filterList(ArrayList<PlantModel> filteredList) {
        plantsList = filteredList;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView imageView;

        MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            description = (TextView) view.findViewById(R.id.description);
            imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }

    public PlantsAdapter(List<PlantModel> plantsList, Context context) {

        this.plantsList = plantsList;
        this.context = context;
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
        final PlantModel plant = plantsList.get(position);
        holder.description.setText(plant.getDescription());
        holder.name.setText(plant.getName());
        Glide
                .with(context)
                .load(plant.getImage())
                .centerCrop()
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Content.class);
                intent.putExtra("name", plant.getName());
                intent.putExtra("description", plant.getDescription());
                context.startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return plantsList.size();
    }
}