package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MySlider(modifier: Modifier = Modifier) {
    var myValue by remember { mutableFloatStateOf(0f) }
    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Slider(value = myValue, onValueChange = { myValue = it })
        Text(myValue.toString())
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySliderAdvance(modifier: Modifier = Modifier) {
    var example by remember { mutableStateOf(":(") }
    val state = remember { SliderState(value = 5f, valueRange = 0f..10f, steps = 3, onValueChangeFinished = {example = ":)"}) }
    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Slider(state, thumb = {Text("0")})
        Text(example)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider(modifier: Modifier = Modifier) {
    var state = remember { RangeSliderState(
        activeRangeStart = 3f,
        activeRangeEnd = 6f,
        valueRange = 0f..10f
    ) }
    Column(modifier.fillMaxSize().padding(horizontal = 30.dp), verticalArrangement = Arrangement.Center) {
        RangeSlider(state = state)
    }
}