package com.davidriad.se.project.se_project_grp8;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AvoidAdapter extends RecyclerView.Adapter<AvoidAdapter.MyViewHolder> {
    private Context context;
    private List<String> avoids;



    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView plantNameAvoid;

        MyViewHolder(View view) {
            super(view);
            plantNameAvoid = (TextView) itemView.findViewById(R.id.plantNameAvoid);
        }
    }

    public AvoidAdapter(List<String> helpsPlantsNames, Context context) {
        this.avoids = helpsPlantsNames;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_relation_wrong, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.plantNameAvoid.setText(avoids.get(position));
    }

    @Override
    public int getItemCount() {
        return avoids.size();
    }
}