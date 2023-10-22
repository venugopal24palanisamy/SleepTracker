package com.venu.sleeptracker.domain.roomDatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "sleep_tracker_table")
data class SleepTrackerData( @PrimaryKey
                             val date: Long,
                             val totalHours: Float)
