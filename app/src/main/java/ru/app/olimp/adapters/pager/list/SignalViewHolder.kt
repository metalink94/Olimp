package ru.app.olimp.adapters.pager.list

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.row_signal.view.*
import ru.app.olimp.signal.SignalModel

class SignalViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(model: SignalModel) {
        itemView.icon.setImageResource(model.imageRes)
        itemView.title.text = model.title ?: "Some Text"
    }
}
