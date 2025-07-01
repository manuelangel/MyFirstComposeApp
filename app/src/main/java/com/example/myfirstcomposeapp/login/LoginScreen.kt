package com.example.myfirstcomposeapp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview()
@Composable
fun Example(text:String = "Hi"){
    Text("$text Manu :)", modifier = Modifier.padding(all = 10.dp).background(Color.Red))
}

@Preview()
@Composable
fun ExampleTwo(text:String = "Hi"){
    Text("$text Manu :)", modifier = Modifier.background(Color.Red).padding(all = 10.dp))
}