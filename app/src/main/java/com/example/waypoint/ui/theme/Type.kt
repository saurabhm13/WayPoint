package com.example.waypoint.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.waypoint.R

val amiriFamily = FontFamily(
    Font(R.font.amiri_regular, weight = FontWeight.Normal),
    Font(R.font.amiri_bold, weight = FontWeight.Bold),
)

val tradeWindsFamily = FontFamily(
    Font(R.font.trade_winds_regular, weight = FontWeight.Normal)
)


val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = tradeWindsFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp
    ),

    titleLarge = TextStyle(
        fontFamily = amiriFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),

    titleMedium = TextStyle(
        fontFamily = amiriFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),

    titleSmall = TextStyle(
        fontFamily = amiriFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),

    labelLarge = TextStyle(
        fontFamily = amiriFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),

    labelMedium = TextStyle(
        fontFamily = amiriFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    ),

    labelSmall = TextStyle(
        fontFamily = amiriFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
)