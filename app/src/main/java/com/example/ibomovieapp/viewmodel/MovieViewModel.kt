package com.example.ibomovieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ibomovieapp.model.MovieDataModel
import com.example.ibomovieapp.network.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(val repository: MovieRepository) : ViewModel() {

    private var _movies: MutableLiveData<List<MovieDataModel>> = MutableLiveData()
    var movies: LiveData<List<MovieDataModel>> = _movies

    private var _selectedMovie: MutableLiveData<MovieDataModel> = MutableLiveData()
    var selectedMovie: LiveData<MovieDataModel> = _selectedMovie

    fun getMovies() {
        viewModelScope.launch {
            val moviesFromApi = repository.getMovies()
            moviesFromApi?.let {
                _movies.postValue(it)
            }
        }
    }

    fun setMovie(movie: MovieDataModel) {
        _selectedMovie.postValue(movie)
    }
}