package com.alexg.topmovies.http


import com.alexg.topmovies.http.apimodel.TopRated

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface MovieApiService {

    @GET("top_rated")
    fun getTopRatedMovies(@Query("page") page: Int?): Observable<TopRated>

}
