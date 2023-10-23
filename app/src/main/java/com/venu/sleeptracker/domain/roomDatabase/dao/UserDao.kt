package com.venu.sleeptracker.domain.roomDatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import com.venu.sleeptracker.domain.roomDatabase.entity.UserDetails

@Dao
interface UserDao {
    @Insert
    suspend fun insertUserDetails(userDetails: UserDetails)

    @Query("SELECT * FROM user_details WHERE email = :email AND password = :password")
    fun getUserByEmailAndPassword(email: String, password: String): UserDetails

}