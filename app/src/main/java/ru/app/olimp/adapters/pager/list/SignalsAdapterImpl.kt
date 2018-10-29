package ru.app.olimp.adapters.pager.list

import android.support.v7.widget.RecyclerView
import android.view.View

interface SignalsAdapterImpl {

    fun removeItems(items: List<*>)

    fun addItems(items: List<*>)

    fun clear()

    fun removeItem(item: Any)

    fun size(): Int

    fun getItem(pos: Int): Any

    fun getRecyclerViewAdapter() : RecyclerView.Adapter<*>
}

interface SignalsAdapterBuilderImpl {

    fun setRecycler(recyclerView: RecyclerView)
    fun setOnClickListener(onClickListener: View.OnClickListener)
    fun build(): SignalsAdapterImpl
}
