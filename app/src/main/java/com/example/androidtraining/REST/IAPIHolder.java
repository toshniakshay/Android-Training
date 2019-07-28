package com.example.androidtraining.REST;

import androidx.room.Delete;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface IAPIHolder {

    @GET("users/{id}")
    Call<ResponseBody> getUser(String userID);

    @POST("users")
    Call<ResponseBody> registerUser();

    @PUT("users")
    Call<ResponseBody> updateUser();

    @Delete()
    Call<ResponseBody> deleteUser();

    @POST("users/authenticate")
    Call<ResponseBody> authenticateUser();

}
