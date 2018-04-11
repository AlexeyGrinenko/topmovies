package com.alexg.topmovies.topmovies

import com.alexg.topmovies.models.DataMovieModel

import rx.Observable

interface TopMoviesActivityMVP {

    interface View {

        fun updateData(dataMovieModel: DataMovieModel)

        fun showSnackbar(s: String)

    }

    interface Presenter {

        fun loadData()

        fun rxUnsubscribe()

        fun setView(view: TopMoviesActivityMVP.View)

    }

    interface Model {

        fun result(): Observable<DataMovieModel>

    }
}
