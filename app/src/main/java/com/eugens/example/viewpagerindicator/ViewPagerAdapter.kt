package com.eugens.example.viewpagerindicator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(
    private val title: List<String>,
    private var details: List<String>,
    private var images: List<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val itemDetails: TextView = itemView.findViewById(R.id.tvAbout)
        val itemImage: TextView = itemView.findViewById(R.id.ivImage)

        init {
            itemImage.setOnClickListener { v: View ->
                val position = adapterPosition
                Toast.makeText(
                    itemView.context,
                    "You clicked on item #${position + 1}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDetails.text = details[position]
        holder.itemImage.setBackgroundResource(images[position])

    }

    override fun getItemCount(): Int {
        return title.size
    }


}
