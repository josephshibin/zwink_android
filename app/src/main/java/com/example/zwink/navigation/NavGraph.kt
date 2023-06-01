package com.example.onboardingcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.zwink.screen.HomeScreen
import com.example.zwink.screen.OnBoardingScreen
import com.example.zwink.screen.SplashScreen
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalPagerApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.SlashScreen.route){
           //  AnimatedSplashScreen(navController=navController)
            SplashScreen(navController=navController)
        }
        composable(route = Screen.Welcome.route) {

            OnBoardingScreen(navController = navController)

        }
        composable(route = Screen.Home.route) {

             HomeScreen()


        }
    }
}