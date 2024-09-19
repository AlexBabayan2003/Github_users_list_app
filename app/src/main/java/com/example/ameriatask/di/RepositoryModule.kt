package com.example.ameriatask.di

import com.example.ameriatask.repo.GithubRepository
import com.example.ameriatask.repo.GithubRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindGithubRepository(repo: GithubRepositoryImpl): GithubRepository

}
