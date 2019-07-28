package com.example.androidtraining.REST;

import com.example.androidtraining.Utils.ApplicationConstants;

import retrofit2.Retrofit;

/**
 * Sinleton pattern class that so that Single API client will be used across the project
 */
public class APIClient {
    private static Retrofit instance;

    public static Retrofit getInstance() {
        if (instance == null) {
            // Thread safe singleton class
            synchronized (APIClient.class) {
                instance = new Retrofit.Builder().
                        baseUrl(ApplicationConstants.ApiConstants.BASE_URL).
                        build();
            }
        }
        return instance;
    }
}
