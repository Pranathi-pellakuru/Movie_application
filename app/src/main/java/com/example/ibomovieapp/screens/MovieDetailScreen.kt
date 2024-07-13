package com.example.ibomovieapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.ibomovieapp.R
import com.example.ibomovieapp.viewmodel.MovieViewModel

@Composable
fun MovieDetailScreen(navController: NavHostController, viewModel: MovieViewModel) {
    val movie = viewModel.selectedMovie.observeAsState()

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .padding(top = 20.dp, start = 10.dp)
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Image(
                    painter = painterResource(id = R.drawable.back_btn),
                    contentDescription = "back button"
                )
            }
        }
        AsyncImage(
            model = movie.value?.imageLandscape,
            contentDescription = "movie banner",
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .padding(vertical = 10.dp)
                .clip(
                    RoundedCornerShape(8.dp)
                )
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.FillHeight,
        )
        movie.value?.let {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(20.dp)
            ) {
                item {
                    Text(
                        text = it.title ?: "", fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    DetailComponent(label = "Released In : ", value = it.dateReleased ?: "")
                    DetailComponent(label = "Type : ", value = it.type ?: "")
                    DetailComponent(label = "Description : ", value = it.description ?: "")
                    DetailComponent(label = "Rating : ", value = it.rating ?: "")
                    DetailComponent(label = "Director : ", value = it.director ?: "")
                    DetailComponent(label = "Actors : ", value = it.actors ?: "")
                    DetailComponent(label = "Language : ", value = it.language ?: "")
                    DetailComponent(label = "Category : ", value = it.category?: "")
                    DetailComponent(label = "Imdb : ", value = it.imdb?: "")
                    DetailComponent(label = "Netflix Id : ", value = it.netflixid ?: "")
                }
            }
        }
    }
}

@Composable
fun DetailComponent(label: String, value: String) {
    Row(modifier = Modifier.padding(4.dp)) {
        Text(
            text = label, fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = value,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    }
}
