package com.appaspect.countdown.notify.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.appaspect.countdown.notify.R

class TimerNotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?)
    {
        showNotification(context!!, "Timer Finished", "Your timer has finished!")

    }

    private fun showNotification(context: Context, title: String, content: String) {
        val channelId = "default_channel_id"
        val notificationId = 1001

        // Create a NotificationManager
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create a NotificationChannel (required for API 26 and above)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Default Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        // Build the notification
        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(content)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Show the notification
        notificationManager.notify(notificationId, builder.build())
    }

}
