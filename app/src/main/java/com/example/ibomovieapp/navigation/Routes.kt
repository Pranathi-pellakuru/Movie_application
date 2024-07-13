package com.example.ibomovieapp.navigation



sealed class Routes (val path : String){
    object MainScreen : Routes(path = "list_screen")
    object DetailsScreen : Routes(path = "details_screen")
}