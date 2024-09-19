package com.example.ameriatask.repo

import com.example.ameriatask.data.GithubUser
import com.example.ameriatask.data.GithubUserDetails


interface GithubRepository {
    suspend fun getUsers(): List<GithubUser>
    suspend fun getUserDetails(username: String): GithubUserDetails
}