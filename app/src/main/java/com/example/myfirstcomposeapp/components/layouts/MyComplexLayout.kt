package com.example.myfirstcomposeapp.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyComplexLayout(modifier: Modifier){
    Column {
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Red)){}
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Cyan)){
            Row {
                Box(Modifier.weight(1f).height(125.dp).background(Color.Green)){}
                Box(Modifier.weight(1f).height(175.dp).background(Color.Gray), contentAlignment = Alignment.Center){
                    Text("Helo there")
                }
            }
        }
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Yellow)){}
    }
}