package ru.lopav.app.getwerunfest

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import ru.lopav.app.getwerunfest.utils.Features

class FreeTradingApp: Application() {

    lateinit var remoteConfig: FirebaseRemoteConfig

    override fun onCreate() {
        FirebaseApp.initializeApp(this)
        remoteConfig = FirebaseRemoteConfig.getInstance()
        remoteConfig.setDefaults(getDefaults())
        remoteConfig.activateFetched()
        fetch()
        super.onCreate()
    }

    private fun fetch() {
        remoteConfig.fetch(120L)
                .addOnSuccessListener {
                    Log.d("FreeTradingApp App", "onSuccessLoaded RemoteConfig")
                    Log.d("FreeTradingApp App", remoteConfig.getString("url"))
                    Log.d("FreeTradingApp App", "is Need Web " + remoteConfig.getBoolean(Features.NEED_WEB))
                }
                .addOnCompleteListener {
                    Log.d("FreeTradingApp App", "onCompleteLoaded RemoteConfig")
                }
                .addOnFailureListener {
                    Log.e("FreeTradingApp App", "onOnFailure RemoteConfig", it)
                }
    }

    private fun getDefaults(): Map<String, Any> {
        return mapOf(
                Features.URL to "https://olymptrade.com/ru-ru/",
                Features.NEED_WEB to false
        )
    }
}
