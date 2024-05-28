package com.example.waypoint.data

import com.example.waypoint.R

data class Place(
    val name: String,
    val image: List<Int>,
    val location: String,
    val rating: Double,
    val ratingCount: Int,
    val description: String
)

val placesList = listOf(
    Place(
        name = "Taj Mahal",
        image = listOf(R.drawable.taj_mahal1, R.drawable.taj_mahal2, R.drawable.taj_mahal3, R.drawable.taj_mahal4),
        location = "Agra, India",
        rating = 4.9,
        ratingCount = 9438,
        description = "The Taj Mahal is an ivory-white marble mausoleum on the right bank of the river Yamuna in Agra, Uttar Pradesh, India. It was commissioned in 1631 by the fifth Mughal emperor, Shah Jahan to house the tomb of his beloved wife, Mumtaz Mahal."
    ),

    Place(
        name = "Taj Mahal",
        image = listOf(R.drawable.taj_mahal1, R.drawable.taj_mahal2, R.drawable.taj_mahal3, R.drawable.taj_mahal4),
        location = "Agra, India",
        rating = 4.9,
        ratingCount = 9438,
        description = "The Taj Mahal is an ivory-white marble mausoleum on the right bank of the river Yamuna in Agra, Uttar Pradesh, India. It was commissioned in 1631 by the fifth Mughal emperor, Shah Jahan to house the tomb of his beloved wife, Mumtaz Mahal."
    ),

    Place(
        name = "Taj Mahal",
        image = listOf(R.drawable.taj_mahal1, R.drawable.taj_mahal2, R.drawable.taj_mahal3, R.drawable.taj_mahal4),
        location = "Agra, India",
        rating = 4.9,
        ratingCount = 9438,
        description = "The Taj Mahal is an ivory-white marble mausoleum on the right bank of the river Yamuna in Agra, Uttar Pradesh, India. It was commissioned in 1631 by the fifth Mughal emperor, Shah Jahan to house the tomb of his beloved wife, Mumtaz Mahal."
    ),

    Place(
        name = "Taj Mahal",
        image = listOf(R.drawable.taj_mahal1, R.drawable.taj_mahal2, R.drawable.taj_mahal3, R.drawable.taj_mahal4),
        location = "Agra, India",
        rating = 4.9,
        ratingCount = 9438,
        description = "The Taj Mahal is an ivory-white marble mausoleum on the right bank of the river Yamuna in Agra, Uttar Pradesh, India. It was commissioned in 1631 by the fifth Mughal emperor, Shah Jahan to house the tomb of his beloved wife, Mumtaz Mahal."
    )
)
