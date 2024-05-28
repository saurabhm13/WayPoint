package com.example.waypoint.data

import com.example.waypoint.R

data class TravelService(
    val image: Int,
    val title: String
)

val travelServiceList = listOf(
    TravelService(R.drawable.hotes, "Hotel"),
    TravelService(R.drawable.car_rent, "Car Rent"),
    TravelService(R.drawable.tourist_guide, "Tourist Guide"),
)
