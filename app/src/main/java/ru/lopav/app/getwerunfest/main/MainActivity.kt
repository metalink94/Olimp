package ru.lopav.app.getwerunfest.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*
import ru.lopav.app.getwerunfest.R
import ru.lopav.app.getwerunfest.adapters.pager.MainViewAdapter
import ru.lopav.app.getwerunfest.artical.ArticalFragment
import ru.lopav.app.getwerunfest.signal.SignalFragment
import ru.lopav.app.getwerunfest.splash.SplashActivity
import ru.lopav.app.getwerunfest.web.WebViewActivity

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (intent.getBooleanExtra(SplashActivity.KEY_BROWSER, false)) {
            openBrowser(intent.getStringExtra(WebViewActivity.KEY_URL))
        } else {
            checkRemoteConfig(
                intent.getBooleanExtra(SplashActivity.KEY_WEB, false),
                intent.getStringExtra(WebViewActivity.KEY_URL)
            )
        }
    }

    private fun openBrowser(stringExtra: String?) {
        if (stringExtra.isNullOrEmpty()) return
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(stringExtra)))
        finish()
    }

    private fun checkRemoteConfig(web: Boolean, url: String?) {
        if (web) {
            showWeb(url)
        } else {
            setAdapter()
            setListeners()
        }
    }

    private fun showWeb(url: String?) {
        startActivity(Intent(this,  WebViewActivity::class.java)
            .putExtra(WebViewActivity.KEY_URL, url))
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
