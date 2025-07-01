package com.example.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.myfirstcomposeapp.R


@Composable
fun MyImage(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.payaso),
        contentDescription = "Avatar image profile",
        contentScale = ContentScale.FillBounds,
        modifier = modifier
            .size(200.dp)
            .clip(CircleShape)
            .border(
                width = 5.dp, brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Red, Color.Cyan, Color.Yellow
                    )
                ), shape = CircleShape
            )
    )
}

@Composable
fun MyIcon(modifier: Modifier) {
    Icon(
        painter = painterResource(R.drawable.baseline_airline_seat_recline_normal_24),
        contentDescription = "Icono",
        modifier = Modifier.size(200.dp),
        tint = Color.Red
    )
}

@Composable
fun MyNetworkImage(modifier: Modifier) {
    AsyncImage(
        modifier = modifier.size(200.dp),
        model = "https://alcoy.salesianos.edu/colegioj23/wp-content/uploads/sites/2/2024/06/payaso-j23.jpg",
        contentDescription = "Image from network",
        onError = { Log.i("TEST_MANU", "ERROR: ${it}") }
    )
}