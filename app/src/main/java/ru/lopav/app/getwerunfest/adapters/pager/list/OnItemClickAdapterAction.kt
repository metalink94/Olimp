package ru.lopav.app.getwerunfest.adapters.pager.list

import android.support.v7.widget.RecyclerView
import android.view.View

class OnItemClickAdapterAction<in M>(val listener:(View) -> Unit) :
    AdapterAction<M, RecyclerView.ViewHolder> {

    override fun bind(model: M, viewHolder: RecyclerView.ViewHolder) {
        viewHolder.itemView.setOnClickListener(listener)
    }
}
