package com.appaspect.countdown.notify
import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.appaspect.countdown.notify.model.TimerViewModel
import com.appaspect.countdown.notify.ui.theme.MyTheme
import com.appaspect.countdown.notify.ui.TimerHomeScreen
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                TimerHomeScreen(this,viewModel = TimerViewModel())
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(this,Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(arrayOf(Manifest.permission.POST_NOTIFICATIONS), 101)

            }
            else {
                // repeat the permission or open app details
            }
        }

    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        Text(text = "Ready... Set... GO!")
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
