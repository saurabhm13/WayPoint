package com.example.waypoint.data

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.example.waypoint.R
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
@Parcelize
data class Place(
    val name: String,
    val image: List<Int>,
    val location: String,
    val rating: Double,
    val ratingCount: Int,
    val description: String
): Parcelable

val customNavType = object : NavType<Place>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Place? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, Place::class.java) as Place
        } else {
            bundle.getParcelable<Place>(key) as Place
        }
    }

    override fun parseValue(value: String): Place {
        return Json.decodeFromString<Place>(value)
    }

    override fun put(bundle: Bundle, key: String, value: Place) {
        bundle.putParcelable(key, value)
    }

    override fun serializeAsValue(value: Place): String {
        return Json.encodeToString(value)
    }

}

val placesList = listOf(
    Place(
        name = "Taj Mahal",
        image = listOf(R.drawable.taj_mahal4, R.drawable.taj_mahal2, R.drawable.taj_mahal3, R.drawable.taj_mahal6, R.drawable.taj_mahal1, R.drawable.taj_mahal5),
        location = "Agra, India",
        rating = 4.9,
        ratingCount = 9438,
        description = "The Taj Mahal is an ivory-white marble mausoleum on the right bank of the river Yamuna in Agra, Uttar Pradesh, India. It was commissioned in 1631 by the fifth Mughal emperor, Shah Jahan to house the tomb of his beloved wife, Mumtaz Mahal."
    ),

    Place(
        name = "Eiffel Tower",
        image = listOf(R.drawable.eiffel_tower1, R.drawable.eiffel_tower2, R.drawable.eiffel_tower3, R.drawable.eiffel_tower4, R.drawable.eiffel_tower5, R.drawable.eiffel_tower6),
        location = "Paris, France",
        rating = 4.7,
        ratingCount = 10948,
        description = "Eiffel Tower, wrought-iron structure in Paris that is among the most famous landmarks in the world. It is also a technological masterpiece in building-construction history. It was designed and built (1887–89) by Gustave Eiffel and named in his honor."
    ),

    Place(
        name = "The Colosseum",
        image = listOf(R.drawable.colosseum1, R.drawable.colosseum2, R.drawable.colosseum3, R.drawable.colosseum4, R.drawable.colosseum5, R.drawable.colosseum6),
        location = "Roma RM, Italy",
        rating = 4.8,
        ratingCount = 8348,
        description = "The Colosseum is an elliptical amphitheatre in the centre of the city of Rome, Italy, just east of the Roman Forum. It is the largest ancient amphitheatre ever built, and is still the largest standing amphitheatre in the world, despite its age."
    ),

    Place(
        name = "Statue of Liberty",
        image = listOf(R.drawable.statue_of_liberty1, R.drawable.statue_of_liberty2, R.drawable.statue_of_liberty3, R.drawable.statue_of_liberty4, R.drawable.statue_of_liberty5, R.drawable.statue_of_liberty6),
        location = "New York, USA",
        rating = 4.7,
        ratingCount = 6438,
        description = "The Statue of Liberty is a colossal neoclassical sculpture on Liberty Island in New York Harbor, within New York City. The copper statue, a gift to the U.S. from the people of France, was designed by French sculptor Frédéric Auguste Bartholdi and its metal framework was built by Gustave Eiffel."
    )
)
