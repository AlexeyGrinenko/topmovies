package com.alexg.topmovies.topmovies

import com.alexg.topmovies.models.DataMovieModel

import rx.Observer
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class TopMoviesPresenter(private val model: TopMoviesActivityMVP.Model) : TopMoviesActivityMVP.Presenter {

    private var view: TopMoviesActivityMVP.View? = null
    private var subscription: Subscription? = null

    override fun loadData() {

        subscription = model
                .result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<DataMovieModel> {
                    override fun onCompleted() {}

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                        if (view != null) {
                            view!!.showSnackbar("Error getting movies")
                        }
                    }

                    override fun onNext(dataMovieModel: DataMovieModel) {
                        if (view != null) {
                            view!!.updateData(dataMovieModel)
                        }
                    }
                })
    }

    override fun rxUnsubscribe() {
        if (subscription != null) {
            if (!subscription!!.isUnsubscribed) {
                subscription!!.unsubscribe()
            }
        }
    }

    override fun setView(view: TopMoviesActivityMVP.View) {
        this.view = view
    }
}
