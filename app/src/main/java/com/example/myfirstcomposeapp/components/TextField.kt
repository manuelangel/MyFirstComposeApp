package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var user by rememberSaveable { mutableStateOf("Manu") }
    var value by rememberSaveable { mutableStateOf("") }
    Column(modifier) {
        MyTextField(user) {
            user = it
        }
        MySecondTextField(value) {
            value = it
        }
        MyAdvanceTextField(value) {
            value = it
        }
        MyPasswordTextField(value) {
            value = it
        }
    }
}

@Composable
fun MyTextField(text: String, onUserChange: (String) -> Unit) {
    TextField(text, onValueChange = { onUserChange(it) }, readOnly = text.isEmpty())
}

@Composable
fun MySecondTextField(text: String, onUserChange: (String) -> Unit) {
    TextField(text, onValueChange = { onUserChange(it) }, placeholder = {
        Box(
            Modifier
                .size(40.dp)
                .background(Color.Red)
        )
    }, label = {
        Text("JEJEJEJ")
    })
}

@Composable
fun MyAdvanceTextField(text: String, onUserChange: (String) -> Unit) {
    TextField(text, onValueChange = {
        if (it.contains("a")) {
            onUserChange(it.replace("a", ""))
        } else {
            onUserChange(it)
        }
    })
}

@Composable
fun MyPasswordTextField(text: String, onValueChange: (String) -> Unit) {
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    TextField(
        value = text,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text("Enter password") },
        visualTransformation =
            if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                val visibilityIcon =
                    if (passwordHidden) Icons.Filled.Call else Icons.Filled.MoreVert
                // Please provide localized description for accessibility services
                val description = if (passwordHidden) "Show password" else "Hide password"
                Icon(imageVector = visibilityIcon, contentDescription = description)
            }
        }
    )
}



