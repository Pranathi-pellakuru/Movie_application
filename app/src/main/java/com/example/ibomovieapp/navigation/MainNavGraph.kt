package com.example.ibomovieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ibomovieapp.screens.MovieDetailScreen
import com.example.ibomovieapp.screens.MovieListingScreen
import com.example.ibomovieapp.viewmodel.MovieViewModel


@Composable
fun MainNavGraph(navHostController: NavHostController,viewModel: MovieViewModel){

   NavHost(navController = navHostController, startDestination = Routes.MainScreen.path) {
       composable(Routes.MainScreen.path){
           MovieListingScreen(navController = navHostController,viewModel = viewModel)
       }
       composable(Routes.DetailsScreen.path){
           MovieDetailScreen(navController = navHostController,viewModel = viewModel)
       }
   }

}