package com.practise.myonlinestore.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.practise.myonlinestore.R
import com.practise.myonlinestore.ui.theme.textFieldColors
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomTextField(
    name: String = "Email Address",
    inputText: String = "Insert email address here",
    onInputChanged: (String) -> Unit,
) {
    TextField(
        value = inputText,
        keyboardOptions = myKeyBoardOption,
        label = { CustomTextLabel(name = name) },
        onValueChange = {
            onInputChanged(it)
        },
        colors = textFieldColors()
    )
}

@Composable
fun MyMediumText(
    modifier: Modifier = Modifier,
    text: String = "",
) {
    Text(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier,
        text = AnnotatedString(
            text,
            spanStyle = SpanStyle(fontStyle = FontStyle(R.font.gilroymedium)),
        )
    )
}

@Composable
@Preview
fun PasswordField(
    inputText: String = "",
    name: String = "Password",
    showPassword: Boolean = false,
    onInputChanged: (String) -> Unit = {},
    toggleShowPassword: (Boolean) -> Unit = {}
) {
    TextField(
        value = inputText,
        colors = textFieldColors(),
        singleLine = true,
        keyboardOptions = myKeyBoardOption,
        visualTransformation = if (showPassword) VisualTransformation.None
        else PasswordVisualTransformation(),
        label = { CustomTextLabel(name) },
        trailingIcon = {
            PasswordTrailingIcon(
                showPassword
            ) {
                toggleShowPassword(it)
            }
        },
        onValueChange = {
            onInputChanged(it)
        },
    )
}

@Composable
fun CustomTextLabel(name: String = "name") {
    Text(
        text = name,
        color = MaterialTheme.colorScheme.tertiary,
        textAlign = TextAlign.Start,
        lineHeight = 29.sp
    )
}

@Composable
fun PasswordTrailingIcon(
    showPassword: Boolean,
    toggleShowPassword: (Boolean) -> Unit
) {
    IconButton(onClick = { toggleShowPassword(!showPassword) }) {
        Image(
            painter = if (showPassword) painterResource(id = R.drawable.ic_visibility_24)
            else painterResource(id = R.drawable.ic_visibility_off_24),
            contentDescription = stringResource(
                id = R.string.password_visibility
            )
        )
    }
}


val myKeyBoardOption = KeyboardOptions(
    keyboardType = KeyboardType.Email,
    imeAction = ImeAction.Done
)