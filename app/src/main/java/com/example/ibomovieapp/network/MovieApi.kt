package com.example.ibomovieapp.network

import com.example.ibomovieapp.model.MovieDataModel
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {

    @GET("wp-content/plugins/whats-on-netflix/json/alldocs.json?_=1700718031139")
    suspend fun getMovies() : Response<List<MovieDataModel>>
}