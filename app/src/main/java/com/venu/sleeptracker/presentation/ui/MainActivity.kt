package com.venu.sleeptracker.presentation.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.venu.sleeptracker.presentation.theme.SleepTrackerTheme
import com.venu.sleeptracker.presentation.ui.navigation.AppNavigation
import com.venu.sleeptracker.presentation.ui.screens.dashboard.DashboardScreen
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SleepTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    AppNavigation(navController = rememberNavController())
                }
            }
        }
    }
}







