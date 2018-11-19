package ru.lopav.app.getwerunfest.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*
import ru.lopav.app.getwerunfest.FreeTradingApp
import ru.lopav.app.getwerunfest.R
import ru.lopav.app.getwerunfest.adapters.pager.MainViewAdapter
import ru.lopav.app.getwerunfest.artical.ArticalFragment
import ru.lopav.app.getwerunfest.signal.SignalFragment
import ru.lopav.app.getwerunfest.splash.SplashActivity
import ru.lopav.app.getwerunfest.utils.Features
import ru.lopav.app.getwerunfest.web.WebViewActivity

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkRemoteConfig()
        checkDataBase()
    }

    private fun checkDataBase() {
        val database = FirebaseDatabase.getInstance()
        database.reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                if (p0.value != null) {
                    val maps = p0.value as Map<String, Any>
                }
                Log.d("DataBase", "get database " + p0.value)
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.d("DataBase", "get database Error " + p0.message)
            }
        })

    }

    private fun checkRemoteConfig() {
        if ((application as FreeTradingApp).remoteConfig.getBoolean(Features.NEED_WEB)) {
            showWeb()
        } else {
            setAdapter()
            setListeners()
        }
    }

    private fun showWeb() {
        startActivity(Intent(this,  WebViewActivity::class.java))
        finish()
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
        adapter = MainViewAdapter(
            supportFragmentManager,
            mutableListOf(articalFragment, signalFragment)
        )
        pager.adapter = adapter
        pager.setPagingEnabled(false)
        pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {

        })

    }
}
