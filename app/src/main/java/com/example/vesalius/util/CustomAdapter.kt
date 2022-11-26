package com.example.vesalius.util


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.vesalius.ItemsViewModel
import com.example.vesalius.R
import com.example.vesalius.SalaModel
import com.example.vesalius.databinding.CardViewDesignBinding

class CustomAdapter(private val salaArrayList: ArrayList<SalaModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private lateinit var binding: CardViewDesignBinding;
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        binding = CardViewDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)


        return  ViewHolder(binding.root)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val sala = salaArrayList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(R.drawable.area)
        holder.nomeSala.text = sala.nome
        holder.professorSala.text = sala.professor
        holder.turmaSala.text = sala.turma
        sala.codigo = " "
        // sets the text to the textview from our itemHolder class



    }

    // return the number of the items in the list
    override fun getItemCount(): Int {

        return salaArrayList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img_sala)
       // val textView: TextView = itemView.findViewById(R.id.titulo_sala)
        val nomeSala: TextView = itemView.findViewById(R.id.titulo_sala)
        val professorSala: TextView = itemView.findViewById(R.id.professor_sala)
        val turmaSala: TextView = itemView.findViewById(R.id.turma_sala)

    }
}