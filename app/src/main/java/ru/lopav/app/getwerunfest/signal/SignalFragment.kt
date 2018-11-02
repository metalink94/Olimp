package ru.lopav.app.getwerunfest.signal

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_signal.*
import ru.lopav.app.getwerunfest.R
import ru.lopav.app.getwerunfest.adapters.pager.list.SignalsAdapterBuilderImpl
import ru.lopav.app.getwerunfest.adapters.pager.list.SignalsAdapterImpl
import ru.lopav.app.getwerunfest.adapters.pager.list.SignalsBuilder

class SignalFragment : Fragment(), View.OnClickListener {

    override fun onClick(p0: View) {
        if (p0.tag is SignalModel) {
            showBottmSheet(p0.tag as SignalModel)
        }
    }

    private fun showBottmSheet(signalModel: SignalModel) {
        SignalBottomSheet.getInstance(signalModel)
            .show(requireActivity().supportFragmentManager, "")
    }

    lateinit var adapter: SignalsAdapterImpl
    val builder: SignalsAdapterBuilderImpl =
        SignalsBuilder()

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
        list.add(SignalModel("EUR/USD", null, R.drawable.one))
        list.add(SignalModel("EUR/USD", null, R.drawable.two))
        list.add(SignalModel("EUR/USD", null, R.drawable.three))
        list.add(SignalModel("EUR/USD", null, R.drawable.four))
        list.add(SignalModel("EUR/USD", null, R.drawable.five))
        list.add(SignalModel("EUR/USD", null, R.drawable.six))
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
