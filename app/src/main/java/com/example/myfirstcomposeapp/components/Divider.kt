package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text("Top")
        HorizontalDivider()
        Text("Bottom")
    }
}