package com.example.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.example.myfirstcomposeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropDownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var selection by remember { mutableStateOf("") }

    LaunchedEffect(expanded) {
        Log.i("TEST_MANU","Cambia a $expanded")
    }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = {
            Log.i("TEST_MANU","Cambia a $expanded and new state is $it")
            expanded = it }) {
        TextField(
            readOnly = true,
            value = selection,
            onValueChange = {},
            label = { Text("Idioma") },
            modifier = Modifier
                .menuAnchor(type = MenuAnchorType.PrimaryNotEditable)
                .fillMaxWidth(),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded)}
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }) {
            DropdownMenuItem(text = { Text("Opcion 1") }, onClick = {
                selection = "Opcion 1"
                expanded = false
            })
            DropdownMenuItem(text = { Text("Opcion 2") }, onClick = {
                selection = "Opcion 2"
                expanded = false
            })
            DropdownMenuItem(text = { Text("Opcion 3") }, onClick = {
                selection = "Opcion 3"
                expanded = false
            })
        }
    }
}

@Composable
fun MyDropDownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier) {
        Button(onClick = { expanded = true }) {
            Text("Ver opciones")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(-16.dp, 16.dp),
            properties = PopupProperties(
                focusable = true,
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
                clippingEnabled = true
            )
        ) {
            DropdownMenuItem(text = { Text("Opcion 1") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("Opcion 2") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("Opcion 3") }, onClick = { expanded = false })
        }
    }

}

@Composable
fun MyDropDownItem(modifier: Modifier = Modifier) {
    Column(modifier) {
        DropdownMenuItem(modifier = Modifier.fillMaxWidth(), text = {
            Text("Hellooo there")
        }, onClick = {}, leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.baseline_airline_seat_recline_normal_24),
                contentDescription = ""
            )
        })
    }
}