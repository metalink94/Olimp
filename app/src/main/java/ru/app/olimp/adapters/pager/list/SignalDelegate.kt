package ru.app.olimp.adapters.pager.list

import android.view.ViewGroup
import org.jetbrains.anko.layoutInflater
import ru.app.olimp.R
import ru.app.olimp.signal.SignalModel

class SignalDelegate(): DelegateAdapter.Delegate<SignalModel, SignalViewHolder>() {
    override fun createViewHolder(parent: ViewGroup): SignalViewHolder {
        val view = parent.context.layoutInflater.inflate(R.layout.row_signal, parent, false)
        return SignalViewHolder(view)
    }

    override fun bind(viewHolder: SignalViewHolder, model: SignalModel) {
        viewHolder.bind(model)
    }

}
