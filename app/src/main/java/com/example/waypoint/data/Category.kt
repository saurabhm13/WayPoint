package com.example.waypoint.data

import androidx.compose.ui.res.painterResource
import com.example.waypoint.R

data class Category(
    val name: String,
    val image: Int
)

val categories = listOf(
    Category("Beach", R.drawable.beach),
    Category("Mountain", R.drawable.mountain),
    Category("Forest", R.drawable.forest),
    Category("Park", R.drawable.park),
)