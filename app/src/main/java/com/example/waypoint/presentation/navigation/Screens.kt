package com.example.waypoint.presentation.navigation

import com.example.waypoint.data.Place
import kotlinx.serialization.Serializable

sealed class Screens {

    @Serializable
    object OnboardingScreen

    @Serializable
    object HomeScreen

    @Serializable
    data class DetailsScreen (
        val place: Place
    )
}