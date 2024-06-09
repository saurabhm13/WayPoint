package com.example.waypoint.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.waypoint.data.Place
import com.example.waypoint.data.customNavType
import com.example.waypoint.presentation.screens.DetailsScreen
import com.example.waypoint.presentation.screens.HomeScreen
import com.example.waypoint.presentation.screens.OnboardingScreen
import kotlin.reflect.typeOf

@Composable
fun NavGraph(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = Screens.OnboardingScreen) {

        composable<Screens.OnboardingScreen> {
            OnboardingScreen(navController)
        }

        composable<Screens.HomeScreen>{
            HomeScreen(navController)
        }

        composable<Screens.DetailsScreen> (
            typeMap = mapOf(typeOf<Place>() to customNavType)
        ) {
            val args = it.toRoute<Screens.DetailsScreen>()
            DetailsScreen(navController = navController, place = args.place)

        }
    }
}