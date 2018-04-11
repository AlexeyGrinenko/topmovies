package com.alexg.topmovies.models


class DataMovieModel(var name: String?, var country: String?, private val poster: String) {

    fun getPoster(): String {
        return poster
    }
}
