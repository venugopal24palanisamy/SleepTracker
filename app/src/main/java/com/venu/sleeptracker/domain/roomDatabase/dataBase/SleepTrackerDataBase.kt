package com.venu.sleeptracker.domain.roomDatabase.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.venu.sleeptracker.domain.roomDatabase.entity.SleepTrackerData

@Database(entities = [SleepTrackerData::class], version = 1)
abstract class SleepTrackerDataBase : RoomDatabase() {
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