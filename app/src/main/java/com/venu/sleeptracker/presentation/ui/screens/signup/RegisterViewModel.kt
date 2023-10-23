package com.venu.sleeptracker.presentation.ui.screens.signup

import android.content.Context
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.venu.sleeptracker.R
import com.venu.sleeptracker.domain.repository.LoginRepository
import com.venu.sleeptracker.domain.roomDatabase.entity.UserDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val loginRepository: LoginRepository) :
    ViewModel() {


    var nameValue by mutableStateOf("")
    var emailValue by mutableStateOf("")
    var phoneValue by mutableStateOf("")
    var passwordValue by mutableStateOf("")
    var confirmPasswordValue by mutableStateOf("")

    var isUserNameError by mutableStateOf(false)
    var isUserEmailError by mutableStateOf(false)
    var isPhoneError by mutableStateOf(false)
    var isPasswordError by mutableStateOf(false)
    var isConfirmPasswordError by mutableStateOf(false)

    var userNameError by mutableStateOf("")
    var userEmailError by mutableStateOf("")
    var phoneError by mutableStateOf("")
    var passwordError by mutableStateOf("")
    var confirmPasswordError by mutableStateOf("")

    var passwordVisibility by mutableStateOf(false)
    var confirmPasswordVisibility by mutableStateOf(false)


    fun validate(context: Context): Boolean {
        if (nameValue.isEmpty()) {
            isUserNameError = true
            userNameError = context.getString(R.string.enter_name)
            return false
        } else {
            isUserNameError = false
            userNameError = ""
        }

        if (emailValue.isEmpty()) {
            isUserEmailError = true
            userEmailError = context.getString(R.string.enter_email)
            return false
        } else {
            isUserEmailError = false
            userEmailError = ""
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()) {
            isUserEmailError = true
            userEmailError = context.getString(R.string.enter_valid_email)
            return false
        } else {
            isUserEmailError = false
            userEmailError = ""
        }

        if (phoneValue.isEmpty()) {
            isPhoneError = true
            phoneError = context.getString(R.string.enter_phone)
            return false
        } else {
            isPhoneError = false
            phoneError = ""
        }

        if (phoneValue.length < 10) {
            isPhoneError = true
            phoneError = context.getString(R.string.enter_valid_phone)
            return false
        } else {
            isPhoneError = false
            phoneError = ""
        }

        if (passwordValue.isEmpty()) {
            isPasswordError = true
            passwordError = context.getString(R.string.enter_password)
            return false
        } else {
            isPasswordError = false
            passwordError = ""
        }

        if (confirmPasswordValue.isEmpty()) {
            isConfirmPasswordError = true
            confirmPasswordError = context.getString(R.string.enter_confirm_password)
            return false
        } else {
            isConfirmPasswordError = false
            confirmPasswordError = ""
        }


        if (confirmPasswordValue != passwordValue) {
            isConfirmPasswordError = true
            confirmPasswordError = context.getString(R.string.password_not_matching)
            return false
        } else {
            isConfirmPasswordError = false
            confirmPasswordError = ""
        }
        return true
    }


    fun registerUser(onRegisterResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val existingUser = loginRepository.getUserByEmailAndPassword(emailValue, passwordValue)
            if (existingUser!=null){
                // User with this email already exists
                onRegisterResult(false)
            }else{
                loginRepository.insertUser(
                    UserDetails(
                        0,
                        nameValue,
                        emailValue,
                        phoneValue,
                        passwordValue
                    )
                )
                onRegisterResult(true)
            }
        }
    }


}