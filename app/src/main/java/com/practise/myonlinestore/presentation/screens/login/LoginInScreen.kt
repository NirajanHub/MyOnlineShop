package com.practise.myonlinestore.presentation.screens.login

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.practise.myonlinestore.R
import com.practise.myonlinestore.domain.model.LoginUser
import com.practise.myonlinestore.navigation.Screens
import com.practise.myonlinestore.presentation.components.CustomTextField
import com.practise.myonlinestore.presentation.components.LoadingButton
import com.practise.myonlinestore.presentation.components.PasswordField
import org.w3c.dom.Text

@Composable
fun LoginScreen(
    navController: NavController,
    loginInViewModel: LoginViewModel = hiltViewModel()
) {

    val uiState by loginInViewModel.uiState.collectAsState()

    val context = LocalContext.current

    val btnEnabled = uiState.emailInput.isNotEmpty()
            && uiState.passwordInput.isNotEmpty()

    val loginUser = LoginUser(
        email = uiState.emailInput,
        password = uiState.passwordInput
    )
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
                painter = painterResource(
                    id = R.drawable.ic_min_carrot
                ),
                contentDescription = "Logo"
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(text = "Login")
            Spacer(modifier = Modifier.padding(8.dp))
            CustomTextField(
                name = "Email",
                inputText = uiState.emailInput,
                onInputChanged = loginInViewModel::onEmailInputChanged
            )
            Spacer(modifier = Modifier.padding(8.dp))
            PasswordField(
                toggleShowPassword = loginInViewModel::togglePassword,
                name = "Password",
                showPassword = uiState.showPassword,
                inputText = uiState.passwordInput,
                onInputChanged = loginInViewModel::onPasswordInputChanged
            )
            Spacer(modifier = Modifier.padding(8.dp))
            LoadingButton(
                text = "Login",
                isLoading = uiState.isLoading,
                enabled = btnEnabled,
                onClicked = {
                    loginInViewModel.onEvent(LoginEvents.Login(loginUser = loginUser))
                }
            )
            ClickableText(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 5.dp),
                text = AnnotatedString(
                    text = "Do not have an account? Sign up!!",
                    spanStyles = listOf(
                        AnnotatedString.Range(
                            SpanStyle(
                                fontStyle = (FontStyle.Italic),
                                color = MaterialTheme.colorScheme.tertiary
                            ), 0, 24
                        )
                    )
                ), onClick = {
                    navController.navigate(Screens.SignUp.route)
                })

        }
    }
}

@Composable
@Preview
fun LoginScreenView() {
    LoginScreen(navController = rememberNavController())
}
