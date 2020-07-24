package com.davidriad.se.project.se_project_grp8;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class HelpedByAdapter extends RecyclerView.Adapter<HelpedByAdapter.MyViewHolder> {
    private Context context;
    private List<String> helpedByPlantsNames;



    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView plantNameHelps;

        MyViewHolder(View view) {
            super(view);
            plantNameHelps = (TextView) itemView.findViewById(R.id.plantNameHelps);
        }
    }

    public HelpedByAdapter(List<String> helpsPlantsNames, Context context) {
        this.helpedByPlantsNames = helpsPlantsNames;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_relation_right, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.plantNameHelps.setText(helpedByPlantsNames.get(position));
    }

    @Override
    public int getItemCount() {
        return helpedByPlantsNames.size();
    }
}