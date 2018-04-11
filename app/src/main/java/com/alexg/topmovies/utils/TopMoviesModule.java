package com.alexg.topmovies.utils;


import com.alexg.topmovies.http.MoreInfoApiService;
import com.alexg.topmovies.http.MovieApiService;
import com.alexg.topmovies.models.TopMoviesModel;
import com.alexg.topmovies.repository.DataRepository;
import com.alexg.topmovies.topmovies.TopMoviesActivityMVP;
import com.alexg.topmovies.repository.TopMoviesDataRepository;
import com.alexg.topmovies.topmovies.TopMoviesPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TopMoviesModule {

    @Provides
    public TopMoviesActivityMVP.Presenter provideTopMoviesActivityPresenter(TopMoviesActivityMVP.Model topMoviesModel) {
        return new TopMoviesPresenter(topMoviesModel);
    }

    @Provides
    public TopMoviesActivityMVP.Model provideTopMoviesActivityModel(DataRepository dataRepository) {
        return new TopMoviesModel(dataRepository);
    }

    @Singleton
    @Provides
    public DataRepository provideRepo(MovieApiService movieApiService, MoreInfoApiService moreInfoApiService) {
        return new TopMoviesDataRepository(movieApiService, moreInfoApiService);
    }


}
