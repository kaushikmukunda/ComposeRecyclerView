package com.km.nestedrvcompose.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.km.nestedrvcompose.R

class ParentAdapter : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = 20

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rv = holder.itemView as RecyclerView
        rv.adapter = ChildAdapter()
        rv.layoutManager = LinearLayoutManager(rv.context, RecyclerView.HORIZONTAL, false)
    }
}