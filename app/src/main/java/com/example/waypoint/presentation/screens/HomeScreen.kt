package com.example.waypoint.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.waypoint.R
import com.example.waypoint.data.Place
import com.example.waypoint.data.categories
import com.example.waypoint.data.placesList
import com.example.waypoint.data.travelServiceList
import com.example.waypoint.presentation.components.CategoryCard
import com.example.waypoint.presentation.components.PlaceCard
import com.example.waypoint.presentation.components.TravelServiceCard
import com.example.waypoint.presentation.navigation.Screens
import com.example.waypoint.ui.theme.Brown

@Composable
fun HomeScreen(
    navController: NavController
) {

    val exploreCategories = listOf("All", "Popular", "Recommended", "Most Viewed")
    var selectedPlaces by remember {
        mutableIntStateOf(0)
    }

    val scrollState = rememberScrollState()

    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars,
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .verticalScroll(scrollState)
        ) {

            // Top Section
            TopSection()

            Column(
                modifier = Modifier.padding(horizontal = 15.dp)
            ) {
                // Category
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = stringResource(id = R.string.categories),
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    for (category in categories) {
                        CategoryCard(name = category.name, image = category.image)
                    }
                }


                // Explore Places
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = stringResource(id = R.string.explore_places),
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(15.dp))
                Row {
                    for ((index, exploreCategory) in exploreCategories.withIndex()) {
                        Text(
                            modifier = Modifier
                                .drawBehind {
                                    val strokeWidthPx = 1.5.dp.toPx()
                                    val verticalOffset = size.height + 0.sp.toPx()
                                    drawLine(
                                        color = if (selectedPlaces == index) Brown else Color.Transparent,
                                        strokeWidth = strokeWidthPx,
                                        start = Offset(0f, verticalOffset),
                                        end = Offset(size.width, verticalOffset)
                                    )}
                                .clickable(onClick = {selectedPlaces = index}),
                            text = exploreCategory,
                            style = MaterialTheme.typography.labelLarge.copy(fontWeight = if (selectedPlaces == index) FontWeight.Bold else FontWeight.Normal)
                        )

                        Spacer(modifier = Modifier.width(25.dp))
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))
                LazyRow {
                    items(placesList.size) { index ->
                        PlaceCard(place = placesList[index], onClick = {
                            navController.currentBackStackEntry?.savedStateHandle?.set(
                                key = "place",
                                value = placesList[index]
                            )
                            navController.navigate(Screens.DetailsScreen.route)
                        })
                    }
                }

                // Travel Services
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = stringResource(id = R.string.travel_services),
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(15.dp))
                LazyRow {
                    items(travelServiceList.size) { index ->
                        TravelServiceCard(travelService = travelServiceList[index])
                    }
                }
            }


        }
    }


}

@Composable
private fun TopSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.forest2),
            contentDescription = stringResource(
                id = R.string.forest
            ),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.padding(horizontal = 15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = stringResource(
                        id = R.string.menu
                    ),
                    tint = Color.White
                )

                Image(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(40.dp))
                        .border(
                            width = 2.dp,
                            color = MaterialTheme.colorScheme.background,
                            shape = RoundedCornerShape(30.dp)
                        ),
                    painter = painterResource(id = R.drawable.head_shot),
                    contentDescription = stringResource(
                        id = R.string.user
                    )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = "", onValueChange = { },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.discover_places),
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = stringResource(
                            id = R.string.search
                        ),
                        tint = Color.Gray
                    )
                },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 30.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.background
                        )
                    )
                )
        ) {

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}