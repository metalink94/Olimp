package ru.app.olimp.signal

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_signal.*
import ru.app.olimp.R
import ru.app.olimp.adapters.pager.list.SignalsAdapterBuilderImpl
import ru.app.olimp.adapters.pager.list.SignalsAdapterImpl
import ru.app.olimp.adapters.pager.list.SignalsBuilder

class SignalFragment: Fragment(), View.OnClickListener {

    override fun onClick(p0: View?) {

    }

    lateinit var adapter: SignalsAdapterImpl
    val builder: SignalsAdapterBuilderImpl = SignalsBuilder()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_signal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        addItems()
    }

    private fun addItems() {
        val list = mutableListOf<SignalModel>()
        list.add(SignalModel("Blue Sea", "Greate blue sea", R.drawable.sea))
        list.add(SignalModel("Ocean", "Greate blue sea", R.drawable.ocean))
        list.add(SignalModel("Yellow Sea", "Greate blue sea", R.drawable.sea))
        list.add(SignalModel("Red Ocean", "Greate blue sea", R.drawable.ocean))
        list.add(SignalModel("Yellow Sea", "Greate blue sea", R.drawable.sea))
        list.add(SignalModel(null, "Greate blue sea", R.drawable.ocean))
        adapter.addItems(list)
    }

    private fun initRecycler() {
        recycler.layoutManager = GridLayoutManager(requireContext(), 2)
        recycler.itemAnimator = DefaultItemAnimator()
        builder.setRecycler(recycler)
        builder.setOnClickListener(this)
        adapter = builder.build()
        recycler.adapter = adapter.getRecyclerViewAdapter()
    }
}
