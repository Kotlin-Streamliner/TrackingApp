package com.streamliner.trackingapp.di

import com.streamliner.trackingapp.data.repositories.MainRepository
import com.streamliner.trackingapp.database.RunDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideMainRepository(runDAO: RunDAO) = MainRepository(runDAO)
}