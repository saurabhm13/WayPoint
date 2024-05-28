package com.example.waypoint.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.waypoint.R
import com.example.waypoint.data.Place
import com.example.waypoint.data.placesList
import com.example.waypoint.ui.theme.Yellow

@Composable
fun DetailsScreen(
    navController: NavController,
    place: Place
) {

    var descriptionMaxLine by remember {
        mutableIntStateOf(6)
    }

    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars,
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Image Section
            item {
                ImageSection(place, navController)
            }

            // Details Section
            item {
                Column(
                    modifier = Modifier.padding(horizontal = 15.dp)
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.weight(1F),
                            text = place.name,
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = stringResource(id = R.string.rating),
                            tint = Yellow
                        )

                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = place.rating.toString(),
                            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                        )

                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "(${place.ratingCount})",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }

                    // Location
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.location),
                            contentDescription = "Location"
                        )

                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = place.location, style = MaterialTheme.typography.bodyMedium)
                    }

                    // Overview
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.overview),
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.clickable {
                            descriptionMaxLine = if (descriptionMaxLine == 6) 9999 else 6
                        },
                        text = place.description,
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = descriptionMaxLine,
                        overflow = TextOverflow.Ellipsis
                    )

                    // Photos
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.Photos),
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }

            // Photos Grid Section
            item {
                LazyVerticalGrid(
                    modifier = Modifier
                        .height(300.dp)
                        .padding(5.dp),
                    columns = GridCells.Fixed(3),
                    content = {
                        items(place.image.size) { index ->
                            Image(
                                modifier = Modifier.padding(5.dp)
                                    .height(100.dp),
                                painter = painterResource(id = place.image[index]),
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                )
            }

            // Additional Padding at the Bottom
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun ImageSection(
    place: Place,
    navController: NavController
) {
    var isFavorite by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(299.dp),
            painter = painterResource(id = place.image[0]),
            contentDescription = "Place Image",
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .padding(end = 10.dp, top = 40.dp)
                .align(Alignment.TopEnd)
                .clickable { isFavorite = !isFavorite }
        ) {
            Image(
                painter = painterResource(id = if (isFavorite) R.drawable.heart_filled else R.drawable.heart_out),
                contentDescription = "Favorite Icon",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
                    .padding(8.dp)
            )
        }

        Box(
            modifier = Modifier
                .padding(start = 10.dp, top = 40.dp)
                .align(Alignment.TopStart)
                .clickable { navController.popBackStack() }
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = "Back Icon",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
                    .padding(8.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.background)
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(rememberNavController(), placesList[0])
}


