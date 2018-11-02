package ru.lopav.app.getwerunfest.adapters.pager.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_signal.view.*
import ru.lopav.app.getwerunfest.signal.SignalModel

class SignalViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(model: SignalModel) {
        Glide.with(itemView.context).load(model.imageRes).into(itemView.icon)
        itemView.tag = model
    }
}
