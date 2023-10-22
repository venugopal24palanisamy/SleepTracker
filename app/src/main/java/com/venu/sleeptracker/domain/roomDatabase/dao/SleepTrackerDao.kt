package com.venu.sleeptracker.domain.roomDatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.venu.sleeptracker.domain.roomDatabase.entity.SleepTrackerData

@Dao
interface SleepTrackerDao {
    @Insert
    fun insert(sleepData: SleepTrackerData)

    @Query("SELECT * FROM sleep_tracker_table")
    fun getAllSleepData(): LiveData<List<SleepTrackerData>>
}