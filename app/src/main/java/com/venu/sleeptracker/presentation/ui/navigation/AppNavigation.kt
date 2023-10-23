package com.venu.sleeptracker.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.venu.sleeptracker.presentation.ui.screens.dashboard.DashboardScreen
import com.venu.sleeptracker.presentation.ui.screens.signin.Login
import com.venu.sleeptracker.presentation.ui.screens.signup.RegisterScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Login.route) {

        composable(Screen.Login.route) {
            Login(navController = navController)
        }

        composable(Screen.Register.route) {
            RegisterScreen(navController = navController)
        }

        composable(Screen.Dashboard.route) {
            DashboardScreen(navController = navController)
        }
    }
}