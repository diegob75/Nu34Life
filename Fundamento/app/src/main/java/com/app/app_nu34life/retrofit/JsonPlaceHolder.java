package com.app.app_nu34life.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface JsonPlaceHolder

{


    void setUrl(String url);

    @GET("recipes")
    Call<List<Recipe>> getCancion();

    @GET("foods")
    Call<List<Food>> getFood();

    @GET
    Call<Recipe> getCancionbyId(@Url String url);

    @POST
    Call<Food>createFood(@Body Food food);
}
