package com.example.ibomovieapp.network

import com.example.ibomovieapp.model.MovieDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MovieRepository @Inject constructor(val movieApi: MovieApi) {

    suspend fun getMovies(): List<MovieDataModel>? {
        var movies: List<MovieDataModel>? = null
        withContext(Dispatchers.IO) {
            val defferedMovies = async {
                movieApi.getMovies()
            }
            val movieResponse = defferedMovies.await()
            if (movieResponse.isSuccessful) {
                movies = movieResponse.body()
            }
        }
        return movies
    }

}