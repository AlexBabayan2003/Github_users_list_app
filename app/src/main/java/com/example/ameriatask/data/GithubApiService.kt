package com.example.ameriatask.data

import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {

    @GET("users")
    suspend fun getUsers(): List<GithubUser>

    @GET("users/{username}")
    suspend fun getUserDetails(@Path("username") username: String): GithubUserDetails
}