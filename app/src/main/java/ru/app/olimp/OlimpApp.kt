package ru.app.olimp

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import ru.app.olimp.utils.Features

class OlimpApp: Application() {

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
        remoteConfig.fetch(60)
                .addOnSuccessListener {
                    Log.d("OlimpApp App", "onSuccessLoaded RemoteConfig")
                    Log.d("OlimpApp App", remoteConfig.getString("url"))
                    Log.d("OlimpApp App", "is Need Web " + remoteConfig.getBoolean(Features.NEED_WEB))
                }
                .addOnCompleteListener {
                    Log.d("OlimpApp App", "onCompleteLoaded RemoteConfig")
                }
                .addOnFailureListener {
                    Log.e("OlimpApp App", "onOnFailure RemoteConfig", it)
                }
    }

    private fun getDefaults(): Map<String, Any> {
        return mapOf(
                Features.URL to "https://olymptrade.com/ru-ru/",
                Features.NEED_WEB to false
        )
    }
}
