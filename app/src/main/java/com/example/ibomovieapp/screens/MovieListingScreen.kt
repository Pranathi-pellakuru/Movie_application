package com.example.ibomovieapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.ibomovieapp.model.MovieDataModel
import com.example.ibomovieapp.navigation.Routes
import com.example.ibomovieapp.viewmodel.MovieViewModel

@Composable
fun MovieListingScreen(navController: NavHostController, viewModel: MovieViewModel) {
    val movieNames = viewModel.movies.observeAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .padding(top = 20.dp, start = 10.dp),
        ) {
            Text(
                text = "Movies",
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp, bottom = 10.dp, top = 20.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(20.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            movieNames.value?.let {
                itemsIndexed(it) { _, item ->
                    MovieCard(item) {
                        viewModel.setMovie(item)
                        navController.navigate(Routes.DetailsScreen.path)
                    }
                }
            }
        }


    }
}

@Composable
fun MovieCard(movie: MovieDataModel, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.Start, modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(8.dp))
        .clickable {
            onClick()
        }
        .padding(vertical = 10.dp)
    ) {
        AsyncImage(
            model = movie.imagePortrait,
            contentDescription = "movie banner",
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.FillWidth,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = movie.title ?: "", fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    }

}