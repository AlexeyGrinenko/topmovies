package com.alexg.topmovies.models


import com.alexg.topmovies.repository.DataRepository
import com.alexg.topmovies.topmovies.TopMoviesActivityMVP
import rx.Observable

class TopMoviesModel(private val mDataRepository: DataRepository) : TopMoviesActivityMVP.Model {

    override fun result(): Observable<DataMovieModel> {
        return Observable.zip(
                mDataRepository.resultData,
                mDataRepository.countryData
        ) { result, s -> DataMovieModel(result.title, s, result.posterPath!!) }
    }

}
