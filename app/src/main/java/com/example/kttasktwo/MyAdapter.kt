package com.example.kttasktwo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.simple_layout.view.*
import java.util.ArrayList

class MyAdapter(private val myDataset: ArrayList<Items>,var clickListener: onItemClickListener) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
     class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageView:ImageView = itemView.image
        var name: TextView = itemView.text
        var price: TextView = itemView.text2

        fun initialize(item:Items,action:onItemClickListener){
            name.setText(item.name)
            price.text = item.price
            imageView.setImageResource(item.image)

            itemView.setOnClickListener{
                action.OnItemClick(item,adapterPosition)
            }
        }


    }



    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // create a new view
        lateinit var viewHolder:MyViewHolder
        viewHolder=MyViewHolder( LayoutInflater.from(parent.context).inflate(R.layout.simple_layout, parent, false))

        // set the view's size, margins, paddings and layout parameters
        return viewHolder
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val item: Items= myDataset[position]
        holder.initialize(item,clickListener)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}
    interface onItemClickListener{
        fun OnItemClick(items:Items,position: Int)
    }