package com.alexg.topmovies.http


import com.alexg.topmovies.http.apimodel.OmdbApi

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface MoreInfoApiService {

    @GET("/")
    fun getCountry(@Query("t") title: String): Observable<OmdbApi>


}
