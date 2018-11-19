package ru.lopav.app.getwerunfest.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ru.lopav.app.getwerunfest.FreeTradingApp
import ru.lopav.app.getwerunfest.OnRemoteComplete
import ru.lopav.app.getwerunfest.R
import ru.lopav.app.getwerunfest.main.MainActivity

class SplashActivity : AppCompatActivity(), OnRemoteComplete {


    override fun onCreate(savedInstanceState: Bundle?) {
        (application as FreeTradingApp).listener = this
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onComplete() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}
