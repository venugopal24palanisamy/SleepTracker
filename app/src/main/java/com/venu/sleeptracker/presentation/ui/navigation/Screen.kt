package com.venu.sleeptracker.presentation.ui.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
    object Register : Screen("register_screen")
    object Dashboard : Screen("dashboard_screen")

}
