package com.example.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.R

@Composable
fun MyButtons(modifier: Modifier) {
    Column(modifier) {
        Button(
            onClick = { Log.i("TEST_MANU", "Pulsado") },
            enabled = true,
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(3.dp, Color.Red),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.Cyan
            )
        ) {
            Text("Pulsame")
        }

        OutlinedButton(onClick = {}) {
            Text("OutlinedButton")
        }

        TextButton(onClick = {}) {
            Text("Pulsame")
        }

        ElevatedButton(onClick = {}) {
            Text("Pulsame")
        }

        FilledTonalButton(onClick = {}) {
            Text("Pulsame")
        }
    }
}

@Composable
fun MyFAB(modifier: Modifier = Modifier, onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        contentColor = Color.White,
        containerColor = Color.Green
    ) {
        Icon(
            painter = painterResource(R.drawable.baseline_airline_seat_recline_normal_24),
            contentDescription = "Floating action button"
        )
    }
}