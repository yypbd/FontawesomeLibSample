package com.yypbd.fontawesomelibsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

import com.yypbd.fontawesomelib.FontawesomeLib
import com.yypbd.fontawesomelib.FontawesomeLib.FontType
import com.yypbd.fontawesomelibsample.IconAdapter.MyViewHolder

class IconAdapter // Provide a suitable constructor (depends on the kind of dataset)
    (private val mFontType: FontType, private val mDataset: ArrayList<IconItem>) :
    RecyclerView.Adapter<MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class MyViewHolder(view: View) : ViewHolder(view) {
        // each data item is just a string in this case
        var textViewIcon: TextView = view.findViewById(R.id.textViewIcon)
        var textViewName: TextView = view.findViewById(R.id.textViewName)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_icon, parent, false)
        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        // holder.textViewIcon.setText(mDataset.get(position).icon);
        holder.textViewName.text = mDataset[position].name
        FontawesomeLib.getInstance()
            .setIcon(mFontType, mDataset[position].name, holder.textViewIcon)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return mDataset.size
    }

}