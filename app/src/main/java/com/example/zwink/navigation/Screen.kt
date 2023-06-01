package com.example.onboardingcompose.navigation

sealed class Screen(val route: String) {

    object SlashScreen:Screen(route = "splash_screen")
    object Welcome : Screen(route = "welcome_screen")
    object Home : Screen(route = "home_screen")
}