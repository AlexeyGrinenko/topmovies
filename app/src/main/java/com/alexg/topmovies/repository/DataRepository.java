package com.alexg.topmovies.repository;


import com.alexg.topmovies.http.apimodel.Result;

import rx.Observable;


public interface DataRepository {

    Observable<Result> getResultsFromMemory();

    Observable<Result> getResultsFromNetwork();

    Observable<String> getCountriesFromMemory();

    Observable<String> getCountriesFromNetwork();

    Observable<String> getCountryData();

    Observable<Result> getResultData();

}
