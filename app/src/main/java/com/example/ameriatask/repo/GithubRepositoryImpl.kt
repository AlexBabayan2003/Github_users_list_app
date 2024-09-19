package com.example.ameriatask.repo

import com.example.ameriatask.data.GithubApiService
import javax.inject.Inject


class GithubRepositoryImpl @Inject constructor(
    private val apiService: GithubApiService
) : GithubRepository {
    override suspend fun getUsers() = apiService.getUsers()
    override suspend fun getUserDetails(username: String) = apiService.getUserDetails(username)
}
