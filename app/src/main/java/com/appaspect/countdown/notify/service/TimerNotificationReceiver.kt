package com.appaspect.countdown.notify.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.appaspect.countdown.notify.AppConstant
import com.appaspect.countdown.notify.R

class TimerNotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?)
    {
        Log.e("TimerNotificationReceiver "," onReceive")
        AppConstant.showNotification(context!!, "Timer Finished", "Your timer has finished!")

    }

}
