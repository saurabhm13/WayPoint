package com.example.waypoint.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.waypoint.data.Place
import com.example.waypoint.presentation.screens.DetailsScreen
import com.example.waypoint.presentation.screens.HomeScreen
import com.example.waypoint.presentation.screens.OnboardingScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = Screens.OnboardingScreen.route) {

        composable(
            route = Screens.OnboardingScreen.route
        ) {
            OnboardingScreen(navController)
        }

        composable(
            route = Screens.HomeScreen.route
        ) {
            HomeScreen(navController)
        }

        composable(
            route = Screens.DetailsScreen.route

        ) {

            val result = navController.previousBackStackEntry?.savedStateHandle?.get<Place>("place")

            if (result != null) {
                DetailsScreen(navController, result)
            }
        }
    }
}