package com.alexg.topmovies.root;

import android.app.Application;

import com.alexg.topmovies.http.ApiModuleForInfo;
import com.alexg.topmovies.http.ApiModuleForName;
import com.alexg.topmovies.utils.TopMoviesModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModuleForName(new ApiModuleForName())
                .topMoviesModule(new TopMoviesModule())
                .apiModuleForInfo(new ApiModuleForInfo())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
