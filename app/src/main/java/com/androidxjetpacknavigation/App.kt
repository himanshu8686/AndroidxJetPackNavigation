package com.androidxjetpacknavigation

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi

/**
 * Project Name :AndroidxJetPackNavigation
 * Created By :Himanshu sharma on 18-04-2021
 * Package : com.androidxjetpacknavigation
 */
const val CHANNEL_ID = "demoChannel"

class App : Application() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        val channel = NotificationChannel(CHANNEL_ID,"Example", NotificationManager.IMPORTANCE_DEFAULT)

        (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(channel)


    }
}