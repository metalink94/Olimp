package ru.app.olimp.main

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.app.olimp.R
import ru.app.olimp.adapters.pager.MainViewAdapter
import ru.app.olimp.artical.ArticalFragment
import ru.app.olimp.signal.SignalFragment

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
        setListeners()
    }

    private fun setListeners() {
        artical.setOnClickListener {
            pager.setCurrentItem(0, true)
        }
        signal.setOnClickListener {
            pager.setCurrentItem(1, true)
        }
    }

    private fun setAdapter() {
        val articalFragment = ArticalFragment()
        val signalFragment = SignalFragment()
        adapter = MainViewAdapter(supportFragmentManager, mutableListOf(articalFragment, signalFragment))
        pager.adapter = adapter
        pager.setPagingEnabled(false)
        pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {

        })

    }
}
