package com.appaspect.countdown.notify.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.appaspect.countdown.notify.AppConstant
import com.appaspect.countdown.notify.AppLog
import com.appaspect.countdown.notify.R

class TimerNotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?)
    {
        AppLog.e("TimerNotificationReceiver  onReceive")
        if(AppConstant.isNotify)
        {
            AppConstant.showNotification(context!!, "Timer Finished", "Your timer has finished!")
        }

    }

}
