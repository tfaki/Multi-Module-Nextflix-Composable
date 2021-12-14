package com.talhafaki.nextflixcomposable.di

import com.talhafaki.data.NextflixRepository
import com.talhafaki.domain.gateway.NextflixGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by tfakioglu on 13.December.2021
 */
@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideNextflixGateway(
        nextflixRepository: NextflixRepository
    ): NextflixGateway = nextflixRepository
}