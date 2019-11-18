package com.app.fas.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface JsonPlaceHolder {


    void setUrl(String url);

    @GET("recipes")
    Call<List<Recipe>> getCancion();

    @GET
    Call<Recipe> getCancionbyId(@Url String url);

}
