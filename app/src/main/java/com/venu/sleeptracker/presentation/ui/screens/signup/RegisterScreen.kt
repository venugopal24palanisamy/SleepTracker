package com.venu.sleeptracker.presentation.ui.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import android.annotation.SuppressLint
import androidx.compose.foundation.Image

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.venu.sleeptracker.R
import com.venu.sleeptracker.presentation.ui.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController) {
    val viewModel: RegisterViewModel = hiltViewModel()

    val context = LocalContext.current
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                Text(
                    modifier = Modifier.padding(start = 15.dp, end = 15.dp),
                    text = "Create Account", fontSize = 30.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(start = 15.dp, end = 15.dp)
                ) {
                    OutlinedTextField(
                        shape = RoundedCornerShape(20),

                        value = viewModel.nameValue,
                        onValueChange = { viewModel.nameValue = it },

                        placeholder = {
                            Text(
                                text = "Name",
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        },
                        textStyle = MaterialTheme.typography.bodyMedium,
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        isError = viewModel.isUserNameError,
                        supportingText = {
                            if (viewModel.isUserNameError) Text(
                                text = viewModel.userNameError,
                                style = MaterialTheme.typography.bodyMedium
                            )

                        }
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    OutlinedTextField(
                        shape = RoundedCornerShape(20),

                        value = viewModel.emailValue,
                        textStyle = MaterialTheme.typography.bodyMedium,
                        onValueChange = { viewModel.emailValue = it },

                        placeholder = {
                            Text(
                                text = "Email Address",
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        isError = viewModel.isUserEmailError,
                        supportingText = {
                            if (viewModel.isUserEmailError) Text(
                                text = viewModel.userEmailError,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    OutlinedTextField(
                        shape = RoundedCornerShape(20),

                        value = viewModel.phoneValue,
                        textStyle = MaterialTheme.typography.bodyMedium,
                        onValueChange = { viewModel.phoneValue = it },

                        placeholder = {
                            Text(
                                text = "Phone Number",
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        },
                        isError = viewModel.isPhoneError,
                        supportingText = {
                            if (viewModel.isPhoneError) Text(
                                text = viewModel.phoneError,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                    )
                    Spacer(modifier = Modifier.padding(10.dp))

                    OutlinedTextField(
                        shape = RoundedCornerShape(20),
                        isError = viewModel.isPasswordError,
                        supportingText = {
                            if (viewModel.isPasswordError) Text(
                                text = viewModel.passwordError,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        value = viewModel.passwordValue,
                        textStyle = MaterialTheme.typography.bodyMedium,
                        onValueChange = { viewModel.passwordValue = it },

                        placeholder = {
                            Text(
                                text = "Password",
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        /*trailingIcon = {
                            IconButton(onClick = {
                                viewModel.passwordVisibility = !viewModel.passwordVisibility
                            }) {
                                Icon(
                                    imageVector = painterResource(id = R.drawable.password_eye),
                                    tint = if (viewModel.passwordVisibility) primaryColor else Color.Gray
                                )
                            }
                        },*/
                        visualTransformation = if (viewModel.passwordVisibility) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.padding(10.dp))

                    OutlinedTextField(
                        shape = RoundedCornerShape(20),
                        isError = viewModel.isConfirmPasswordError,
                        supportingText = {
                            if (viewModel.isConfirmPasswordError) Text(
                                text = viewModel.confirmPasswordError,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        value = viewModel.confirmPasswordValue,
                        textStyle = MaterialTheme.typography.bodyMedium,
                        onValueChange = { viewModel.confirmPasswordValue = it },

                        placeholder = {
                            Text(
                                text = "Confirm Password",
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        /*trailingIcon = {
                            IconButton(onClick = {
                                viewModel.confirmPasswordVisibility =
                                    !viewModel.confirmPasswordVisibility
                            }) {
                                Icon(
                                    imageVector = painterResource(id = com.venu.sleeptracker.R.drawable.ic_moon_white),
                                    tint = if (viewModel.confirmPasswordVisibility) Color.Black else Color.Gray
                                )
                            }
                        },*/
                        visualTransformation = if (viewModel.confirmPasswordVisibility) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .layoutId("loginButton")
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = {
                                if (viewModel.validate(context)) {
                                 viewModel.registerUser {

                                     if (it){
                                         navController.navigate(Screen.Dashboard.route)
                                     }
                                 }
                                }
                            },
                            shape = RoundedCornerShape(35),
                            modifier = Modifier
                                .height(55.dp)
                                .fillMaxWidth()
                                .padding(start = 15.dp, end = 15.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black
                            )
                        ) {
                            Text(
                                text = stringResource(R.string.signup),
                                color = Color.White,
                                style = MaterialTheme.typography.labelLarge,
                                modifier = Modifier.padding(5.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .layoutId("loginRegister")
                            .padding(top = 15.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.oldAccount),
                            color = Color.Gray,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(5.dp)
                        )
                        Text(
                            text = stringResource(R.string.login),
                            color = Color.Black,
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier
                                .padding(5.dp)
                                .clickable { navController.popBackStack() },
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.padding(20.dp))

                }

            }
        }
    }
}