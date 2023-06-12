package com.example.ashutosh.API

import com.example.ashutosh.Model.Post
import com.example.ashutosh.Model.Result
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

public interface APIUtility {

    @GET("/posts")
    suspend fun getAllPhotos(): List<Post>

}