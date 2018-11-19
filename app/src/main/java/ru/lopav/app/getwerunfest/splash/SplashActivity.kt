package ru.lopav.app.getwerunfest.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import ru.lopav.app.getwerunfest.R
import ru.lopav.app.getwerunfest.main.MainActivity
import ru.lopav.app.getwerunfest.web.WebViewActivity.Companion.KEY_URL

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        checkDataBase()
    }

    private fun checkDataBase() {
        val database = FirebaseDatabase.getInstance()
        database.reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                if (p0.value != null) {
                    val web = p0.child("web").value as Boolean
                    val url = p0.child("site").value as String?
                    openMainActivity(web, url)
                    Log.d("DataBase", "get Web $url")
                }
                Log.d("DataBase", "get database ${p0.value}")
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.d("DataBase", "get database Error " + p0.message)
                openMainActivity()
            }
        })
    }

    private fun openMainActivity(isWeb: Boolean = false, url: String? = null) {
        startActivity(
            Intent(this, MainActivity::class.java)
                .putExtra(KEY_WEB, isWeb)
                .putExtra(KEY_URL, url)
        )
        finish()
    }

    companion object {
        const val KEY_WEB = "web"
    }

}
