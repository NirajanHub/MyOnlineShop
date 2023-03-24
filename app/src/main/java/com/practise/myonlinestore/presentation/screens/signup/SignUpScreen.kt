package com.practise.myonlinestore.presentation.screens.signup

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.practise.myonlinestore.R
import com.practise.myonlinestore.domain.model.SignUpUser
import com.practise.myonlinestore.navigation.Screens
import com.practise.myonlinestore.presentation.components.CustomTextField
import com.practise.myonlinestore.presentation.components.LoadingButton
import com.practise.myonlinestore.presentation.components.PasswordField

@Composable
fun SignUpScreen(
    navController: NavController,
    signUpViewModel: SignUpViewModel = hiltViewModel()
) {
    val uiState by signUpViewModel.uiState.collectAsState()

    val signUp = SignUpUser(
        name = uiState.nameInput,
        email = uiState.emailInput,
        password = uiState.passwordInput,
        passwordConfirmation = uiState.confirmPasswordInput,
    )

    val context = LocalContext.current

    val btnEnabled = uiState.nameInput.isNotEmpty() &&
            uiState.emailInput.isNotEmpty() &&
            uiState.passwordInput.isNotEmpty() &&
            uiState.passwordInput == uiState.confirmPasswordInput


    LaunchedEffect(key1 = uiState.isLoading) {
        if (!uiState.isLoading && uiState.result.isNotEmpty() && uiState.errorMessage.isEmpty()) {
            Toast.makeText(
                context,
                "User ${uiState.result} signed up successfully", Toast.LENGTH_LONG
            ).show()
            navController.popBackStack()
            navController.navigate(Screens.Login.route) { launchSingleTop = true }
        } else if (uiState.errorMessage.isNotEmpty()) {
            Toast.makeText(context, uiState.errorMessage, Toast.LENGTH_LONG).show()
        }
    }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_min_carrot),
                contentDescription = "AppLogo"
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(text = "Sign Up")
            Spacer(modifier = Modifier.padding(10.dp))
            CustomTextField(
                name = "Name", inputText = uiState.nameInput,
                signUpViewModel::onNameInputChanged
            )
            Spacer(modifier = Modifier.padding(10.dp))
            CustomTextField(
                name = "Email Address", inputText = uiState.emailInput,
                signUpViewModel::onEmailInputChanged
            )
            Spacer(modifier = Modifier.padding(8.dp))
            PasswordField(
                inputText = uiState.passwordInput,
                showPassword = false,
                onInputChanged = signUpViewModel::onPasswordInputChanged,
                toggleShowPassword = signUpViewModel::togglePassword
            )
            Spacer(modifier = Modifier.padding(8.dp))
            PasswordField(
                inputText = uiState.confirmPasswordInput,
                showPassword = uiState.showPassword,
                name = "Confirm Password",
                onInputChanged = signUpViewModel::onConfirmPasswordInputChanged,
                toggleShowPassword = signUpViewModel::togglePassword
            )
            Spacer(modifier = Modifier.padding(10.dp))
            LoadingButton(
                text = "Sign Up",
                isLoading = uiState.isLoading,
                enabled = btnEnabled,
                onClicked = {
                    signUpViewModel.onEvents(SignUpEvents.SignUp(signUp))
                    Log.d("signupScreen: ", uiState.errorMessage)
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            ClickableText(
                modifier = Modifier.align(Alignment.End).padding(end = 5.dp),
                text = AnnotatedString(
                    text = "Already have an account? Goto Login!!",
                    spanStyles = listOf(
                        AnnotatedString.Range(
                            SpanStyle(
                                fontStyle = (FontStyle.Italic),
                                color = MaterialTheme.colorScheme.tertiary
                            ), 0, 25
                        )
                    )
                ), onClick = {
                    navController.navigate(Screens.Login.route)
                })
        }
    }
}
