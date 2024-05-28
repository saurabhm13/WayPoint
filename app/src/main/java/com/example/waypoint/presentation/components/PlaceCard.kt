package com.example.waypoint.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.waypoint.R
import com.example.waypoint.data.Place
import com.example.waypoint.data.placesList
import com.example.waypoint.ui.theme.Yellow

@Composable
fun PlaceCard(
    place: Place
) {

    var isFavorite by remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier.width(130.dp)
            .padding(4.dp)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(15.dp)
            ),
        shape = RoundedCornerShape(15.dp)
    ) {
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(90.dp)
                    .width(150.dp)
            ) {
                Image(
                    modifier = Modifier
                        .height(90.dp)
                        .width(140.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    painter = painterResource(id = place.image[0]), contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .padding(6.dp)
                        .align(Alignment.TopEnd)
                        .clickable { isFavorite = !isFavorite }
                ) {
                    Image(
                        painter = painterResource(id = if (isFavorite) R.drawable.heart_filled else R.drawable.heart_out),
                        contentDescription = "Favorite Icon",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color.White)
                            .padding(6.dp),

                        )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(1F),
                    text = place.name, style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    modifier = Modifier.size(15.dp),
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = stringResource(
                        id = R.string.rating
                    ),
                    tint = Yellow
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = place.rating.toString(),
                    style = MaterialTheme.typography.labelMedium.copy(color = Color.Gray)
                )
            }

//            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    modifier = Modifier.size(15.dp),
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = stringResource(
                        id = R.string.location
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = place.location,
                    style = MaterialTheme.typography.labelMedium
                )

            }
        }
    }

}

@Preview
@Composable
fun PlaceCardPreview() {
    PlaceCard(place = placesList[0])
}