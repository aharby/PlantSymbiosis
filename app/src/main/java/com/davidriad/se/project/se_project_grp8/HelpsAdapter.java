package com.davidriad.se.project.se_project_grp8;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class HelpsAdapter extends RecyclerView.Adapter<HelpsAdapter.MyViewHolder> {
    private Context context;
    private List<String> helpsPlantsNames;



    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView plantNameHelps;

        MyViewHolder(View view) {
            super(view);
            plantNameHelps = (TextView) itemView.findViewById(R.id.plantNameHelps);
        }
    }

    public HelpsAdapter(List<String> helpsPlantsNames, Context context) {
        this.helpsPlantsNames = helpsPlantsNames;
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
        holder.plantNameHelps.setText(helpsPlantsNames.get(position));
    }

    @Override
    public int getItemCount() {
        return helpsPlantsNames.size();
    }
}