package ru.lopav.app.getwerunfest.adapters.pager.list

import android.view.ViewGroup
import org.jetbrains.anko.layoutInflater
import ru.lopav.app.getwerunfest.R
import ru.lopav.app.getwerunfest.signal.SignalModel

class SignalDelegate(): DelegateAdapter.Delegate<SignalModel, SignalViewHolder>() {
    override fun createViewHolder(parent: ViewGroup): SignalViewHolder {
        val view = parent.context.layoutInflater.inflate(R.layout.row_signal, parent, false)
        return SignalViewHolder(view)
    }

    override fun bind(viewHolder: SignalViewHolder, model: SignalModel) {
        viewHolder.bind(model)
    }

}
