package com.example.vesalius

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ViewPagerAdapter ( private var details: List <String>, private var images: List <Int>) : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder> () {

    inner class Pager2ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val itemdetails: TextView = itemView.findViewById(R.id.txt_board)
        val itemimage: ImageView = itemView.findViewById(R.id.img_board)

        init {
            itemimage.setOnClickListener {
                v : View ->
                val position = adapterPosition
                Toast.makeText(itemView.context," You cliqued on item #${position +1}",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page,parent,false))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
       holder.itemdetails.text = details [position]
        holder.itemimage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
       return details.size
    }


}