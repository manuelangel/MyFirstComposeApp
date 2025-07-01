package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun MyTexts(modifier: Modifier) {

    Column(modifier) {
        Text(text = "Pepe2")
        Text(text = "Pepe rojo", color = Color.Red)
        Text(text = "Pepe rojo", fontSize = 25.sp)
        Text(text = "FontStyle", fontStyle = FontStyle.Italic)
        Text(text = "FontWeight", fontWeight = FontWeight.ExtraBold)
        Text("LetterSpacing", letterSpacing = 32.sp)
        Text("TextDecoration", textDecoration = TextDecoration.LineThrough + TextDecoration.Underline)
    }
}