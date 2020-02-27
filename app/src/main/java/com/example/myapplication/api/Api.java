package com.example.myapplication.api;

import com.example.myapplication.model.RespuestaApi;
import com.example.myapplication.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {


    @GET("api.php?amount=1&category=18&difficulty=medium&type=boolean")
    Call<RespuestaApi> getQuestion();
}
