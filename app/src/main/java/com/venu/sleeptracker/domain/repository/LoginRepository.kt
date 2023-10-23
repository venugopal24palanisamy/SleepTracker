package com.venu.sleeptracker.domain.repository

import com.venu.sleeptracker.domain.roomDatabase.dao.UserDao
import com.venu.sleeptracker.domain.roomDatabase.entity.UserDetails
import javax.inject.Inject

class LoginRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun insertUser(userDetails: UserDetails) = userDao.insertUserDetails(userDetails)

    fun getUserByEmailAndPassword(email: String, password: String): UserDetails =
        userDao.getUserByEmailAndPassword(email, password)


}