package com.venu.sleeptracker.di

import android.content.Context
import com.venu.sleeptracker.domain.roomDatabase.dao.SleepTrackerDao
import com.venu.sleeptracker.domain.roomDatabase.dao.UserDao
import com.venu.sleeptracker.domain.roomDatabase.dataBase.SleepTrackerDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): SleepTrackerDataBase =
        SleepTrackerDataBase.getInstance(context)

    @Provides
    @Singleton
    fun provideUserDAO(sleepTrackerDataBase: SleepTrackerDataBase): UserDao =
        sleepTrackerDataBase.userDao()

    @Provides
    @Singleton
    fun provideSleepTrackerDAO(sleepTrackerDataBase: SleepTrackerDataBase): SleepTrackerDao =
        sleepTrackerDataBase.sleepTrackerDao()


}