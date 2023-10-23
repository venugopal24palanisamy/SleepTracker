package com.venu.sleeptracker.domain.roomDatabase.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.venu.sleeptracker.domain.roomDatabase.dao.SleepTrackerDao
import com.venu.sleeptracker.domain.roomDatabase.dao.UserDao
import com.venu.sleeptracker.domain.roomDatabase.entity.SleepTrackerData
import com.venu.sleeptracker.domain.roomDatabase.entity.UserDetails

@Database(entities = [SleepTrackerData::class, UserDetails::class], version = 1)
abstract class SleepTrackerDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun sleepTrackerDao(): SleepTrackerDao
    companion object {
        private var INSTANCE: SleepTrackerDataBase? = null
        fun getInstance(context: Context): SleepTrackerDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SleepTrackerDataBase::class.java,
                        "SleepTrackerDataBase.db"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}