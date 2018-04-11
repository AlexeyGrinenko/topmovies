package com.alexg.topmovies.root;

import com.alexg.topmovies.http.ApiModuleForInfo;
import com.alexg.topmovies.http.ApiModuleForName;
import com.alexg.topmovies.topmovies.TopMoviesActivity;
import com.alexg.topmovies.utils.TopMoviesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModuleForName.class, ApiModuleForInfo.class,TopMoviesModule.class})
public interface ApplicationComponent {

    void inject(TopMoviesActivity target);

}
