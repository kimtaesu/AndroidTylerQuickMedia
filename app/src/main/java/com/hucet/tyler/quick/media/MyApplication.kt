package com.hucet.tyler.quick.media

import android.app.Activity
import android.app.Application
import com.hucet.tyler.memo.OpenForTesting
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


@OpenForTesting
class MyApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
//        AppInjector.init(this)
//        fetchRemoteConfig()
    }
//    private fun fetchRemoteConfig() {
//        FirebaseApp.initializeApp(this)
//        FirebaseRemoteConfig.getInstance().apply {
//            setConfigSettings(FirebaseRemoteConfigSettings.Builder()
//                    .setDeveloperModeEnabled(BuildConfig.DEBUG)
//                    .build())
//            setDefaults(R.xml.default_remote_config)
//        }.run {
//            val cacheExpirationSecond = if (BuildConfig.DEBUG) 0L else 60 * 60 * 12 // 12 hours
//            fetch(cacheExpirationSecond).addOnCompleteListener { task ->
//                if (task.isSuccessful) activateFetched()
//            }
//        }
//    }

}
