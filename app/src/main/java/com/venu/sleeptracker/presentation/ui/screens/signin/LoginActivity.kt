package com.venu.sleeptracker.presentation.ui.screens.signin


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.venu.sleeptracker.R
import com.venu.sleeptracker.presentation.ui.navigation.Screen

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(
    navController: NavController,

    ) {
    val viewModel: LoginViewModel = hiltViewModel()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()



    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    BoxWithConstraints(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .height(50.dp)
                            .width(50.dp)
                            .fillMaxWidth()
                            .background(
                                color = Color.Black,
                                shape = RoundedCornerShape(15)
                            ),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_moon_white),
                            contentDescription = stringResource(
                                id = R.string.app_name
                            ), modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(15.dp)
                        )
                    }
                }
                BoxWithConstraints(modifier = Modifier.padding(top = 10.dp)) {
                    Text(
                        text = stringResource(R.string.app_name),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
                Card(
                    modifier = Modifier.padding(15.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(
                        hoveredElevation = 10.dp,
                        defaultElevation = 8.dp
                    )
                ) {
                    ConstraintLayout(
                        modifier = Modifier
                            .padding(15.dp)
                            .fillMaxWidth(),
                        constraintSet = setUserLoginConstraints()
                    ) {
                        Text(
                            text = stringResource(R.string.login),
                            modifier = Modifier
                                .fillMaxWidth()
                                .layoutId("loginTitle"),
                            color = Color.Black,
                            style = MaterialTheme.typography.titleLarge,
                            fontSize = 20.sp
                        )
                        Box(
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .layoutId("loginSubTitle")

                        ) {
                            Text(
                                text = stringResource(R.string.welcome_back),
                                fontSize = 18.sp,
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.Gray,
                            )
                        }
                        Box(
                            Modifier
                                .padding(top = 15.dp)
                                .layoutId("loginUserName")
                        ) {
                            OutlinedTextField(
                                value = viewModel.loginUserName,
                                onValueChange = {
                                    viewModel.loginUserName = it
                                },
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textStyle = MaterialTheme.typography.bodyMedium,
                                shape = RoundedCornerShape(20),
                                placeholder = {
                                    Text(
                                        text = stringResource(R.string.email),
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text,
                                    imeAction = ImeAction.Next
                                ),
                                isError = viewModel.isUserNameError,
                                supportingText = {
                                    if (viewModel.isUserNameError) Text(
                                        text = viewModel.loginUserNameError,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            )


                        }
                        Box(
                            Modifier
                                .padding(top = 15.dp)
                                .layoutId("loginPassword")
                        ) {
                            OutlinedTextField(
                                visualTransformation = if (viewModel.isPasswordToggled) VisualTransformation.None else PasswordVisualTransformation(),
                                value = viewModel.loginUserPassword,
                                onValueChange = {
                                    viewModel.loginUserPassword = it
                                },
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(20),
                                textStyle = MaterialTheme.typography.bodyMedium,
                                placeholder = {
                                    Text(
                                        text = stringResource(R.string.password),
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Password,
                                    imeAction = ImeAction.Done
                                ), isError = viewModel.isPasswordError,
                                supportingText = {
                                    if (viewModel.isPasswordError) Text(
                                        text = viewModel.loginUserPasswordError,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            )
                        }


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
                                    text = stringResource(R.string.login),
                                    color = Color.White,
                                    style = MaterialTheme.typography.labelLarge,
                                    modifier = Modifier.padding(5.dp)
                                )
                            }
                        }


                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .layoutId("loginRegister")
                                .padding(top = 15.dp)
                        ) {

                            Text(
                                text = stringResource(R.string.createAccount),
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(5.dp)
                            )

                            Text(
                                text = stringResource(R.string.signup),
                                color = Color.Black,

                                modifier = Modifier
                                    .padding(5.dp)
                                    .clickable { navController.navigate(Screen.Register.route) },
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )

                        }
                        if (viewModel.isLoading)
                            Box(modifier = Modifier.layoutId("loginLoader")) {
                                //CircularLoader()
                            }
                    }
                }
            }
        }
    }
}


@Composable
fun setUserLoginConstraints(): ConstraintSet {
    return ConstraintSet {
        val loginTitleConstraint = createRefFor("loginTitle")
        val loginSubTitleConstraint = createRefFor("loginSubTitle")
        val loginUserNameConstraint = createRefFor("loginUserName")
        val loginPasswordConstraint = createRefFor("loginPassword")
        val loginButtonConstraint = createRefFor("loginButton")
        val loginRegisterConstraint = createRefFor("loginRegister")
        val loginLoaderConstraint = createRefFor("loginLoader")

        constrain(loginLoaderConstraint) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(loginTitleConstraint) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }

        constrain(loginSubTitleConstraint) {
            top.linkTo(loginTitleConstraint.bottom)
            start.linkTo(parent.start)
        }

        constrain(loginUserNameConstraint) {
            top.linkTo(loginSubTitleConstraint.bottom)
        }

        constrain(loginPasswordConstraint) {
            top.linkTo(loginUserNameConstraint.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(loginButtonConstraint) {
            top.linkTo(loginPasswordConstraint.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(loginRegisterConstraint) {
            top.linkTo(loginButtonConstraint.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewPreview() {
    Login(navController = rememberNavController())
}
