package ru.app.olimp.adapters.pager.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import ru.app.olimp.signal.SignalModel

class SignalsAdapter(val delegateAdapter: DelegateAdapter): SignalsAdapterImpl {
    override fun removeItems(items: List<*>) {
        delegateAdapter.removeItems(items)
    }

    override fun addItems(items: List<*>) {
        delegateAdapter.addItems(items)
    }

    override fun clear() {
        delegateAdapter.clearItems()
    }

    override fun removeItem(item: Any) {
        delegateAdapter.removeItem(item)
    }

    override fun size(): Int {
        return delegateAdapter.itemCount
    }

    override fun getItem(pos: Int): Any {
        return delegateAdapter.getItem(pos)
    }

    override fun getRecyclerViewAdapter(): RecyclerView.Adapter<*> {
        return delegateAdapter
    }
}

class SignalsBuilder: SignalsAdapterBuilderImpl {

    var recyclerView: RecyclerView? = null
    val builder = DelegateAdapter.Builder()
    var onClick: (View) -> Unit = {}

    override fun setRecycler(recyclerView: RecyclerView) {
        this.recyclerView = recyclerView
    }

    override fun setOnClickListener(onClickListener: View.OnClickListener) {
        onClick = { onClickListener.onClick(it) }
    }

    override fun build(): SignalsAdapterImpl {
        return SignalsAdapter(createDelegateAdapter())
    }

    private fun createDelegateAdapter(): DelegateAdapter {
        builder.addDelegate(SignalModel::class.java, SignalDelegate(), OnItemClickAdapterAction(onClick))
        return builder.build()
    }

}
