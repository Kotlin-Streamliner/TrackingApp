package com.streamliner.trackingapp.di

import android.content.Context
import androidx.room.Room
import com.streamliner.trackingapp.utils.Consts
import com.streamliner.trackingapp.database.RunningDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunningDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        RunningDatabase::class.java,
        Consts.RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDAO(database: RunningDatabase) = database.getRunDao()
}