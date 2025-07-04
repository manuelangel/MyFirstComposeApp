package com.example.myfirstcomposeapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyBadge(modifier: Modifier = Modifier) {
    Badge(
        contentColor = Color.Yellow,
        containerColor = Color.Gray
    ) {
        Text("4")
    }
}

@Preview
@Composable
fun MyBadgeBox(modifier: Modifier = Modifier) {
    BadgedBox(modifier = modifier, badge = {MyBadge()}) {
        Icon(imageVector = Icons.Default.Search, contentDescription = "")
    }
}