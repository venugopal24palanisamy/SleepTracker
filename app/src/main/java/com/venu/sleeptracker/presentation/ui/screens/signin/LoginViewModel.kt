package com.venu.sleeptracker.presentation.ui.screens.signin

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.venu.sleeptracker.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    var loginUserName by mutableStateOf("")
    var loginUserPassword by mutableStateOf("")

    var loginUserNameError by mutableStateOf("")
    var loginUserPasswordError by mutableStateOf("")

    val isPasswordToggled by mutableStateOf(false)
    var isPasswordError by mutableStateOf(false)
    var isUserNameError by mutableStateOf(false)
    var isLoading by mutableStateOf(false)

    fun validate(context: Context): Boolean {
        if (loginUserName.isEmpty()) {
            isUserNameError = true
            loginUserNameError = context.getString(R.string.enter_email)
            return false
        } else {
            isUserNameError = false
            loginUserNameError = ""
        }
        if (loginUserPassword.isEmpty()) {
            isPasswordError = true
            loginUserPasswordError = context.getString(R.string.enter_password)
            return false
        } else {
            isPasswordError = false
            loginUserPasswordError = ""
        }
        return true
    }
}