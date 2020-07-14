package com.davidriad.se.project.se_project_grp8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class EditHelpsPlantAdapter(
        private val plants: List<String>,
        private val context: Context,
        private val id:String
) : RecyclerView.Adapter<EditHelpsPlantAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val plantName = view.findViewById<TextView>(R.id.help_name)

        fun bind(plant: String) {
            plantName.text = plant
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent!!.getContext())
        val view = inflater.inflate(R.layout.item_help_edit_activity, parent, false)

        return ViewHolder(view)
//                .listen { pos, type ->
//            var plant = plants[pos]
//            plant.isFollow = !plant.isFollow
//            notifyDataSetChanged()
//        }

    }

    override fun getItemCount(): Int {
        return plants.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(plants[position])

    }

    private fun <T : ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(adapterPosition, itemViewType)
        }
        return this
    }

}
