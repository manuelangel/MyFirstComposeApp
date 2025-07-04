@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.example.myfirstcomposeapp.components.model.PokemonCombat
import java.util.Calendar

@Composable
fun MyDialog(modifier: Modifier = Modifier) {
    //Si no modifico el shape, utiliza el del sistema, descrito en el fichero theme
    var showDialog by remember { mutableStateOf(true) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = { Button(onClick = { showDialog = false }) { Text("Entendido") } },
            dismissButton = { TextButton(onClick = { showDialog = false }) { Text("Cancelar") } },
            text = { Text("Descripcion del dialog") },
            title = { Text("Quieres hacer esta accion?") },
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "") },
            properties = DialogProperties(
                dismissOnBackPress = false,
                securePolicy = SecureFlagPolicy.SecureOn //Seguridad para capturas de pantalla para que no salga el contenido
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDateDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, 1)
    calendar.set(Calendar.MONTH, Calendar.JANUARY)
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val filterCalendar = Calendar.getInstance().apply { timeInMillis = utcTimeMillis }
                val day = filterCalendar.get(Calendar.DAY_OF_MONTH)
                return day % 2 == 0
            }
        }
    )
    if (showDialog) {
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    val result = datePickerState.selectedDateMillis
                    if (result != null) {
                        val newCalendar = Calendar.getInstance().apply { timeInMillis = result }
                    }
                    showDialog = false
                }) { Text("Confirmar") }
            }
        ) {
            DatePicker(datePickerState)
        }
    }
}

@Composable
fun MyTimePicker(modifier: Modifier = Modifier) {
    var showTimePicker by remember { mutableStateOf(true) }
    val timePickerState = rememberTimePickerState(
        is24Hour = true
    )

    if (showTimePicker) {
        Dialog(onDismissRequest = { showTimePicker = false }) {
            Column(modifier = Modifier.background(Color.Red)) {
                TimePicker(
                    timePickerState,
                    layoutType = TimePickerLayoutType.Horizontal
                )
            }
        }
    }
}

@Composable
fun MyCustomDialog(
    modifier: Modifier = Modifier,
    showDialog: Boolean,
    onDismissDialog: () -> Unit,
    pokemonCombat: PokemonCombat
) {
    if (showDialog) {
        Dialog(onDismissRequest = { onDismissDialog() }) {
            Column(modifier.fillMaxWidth().background(Color.White)) {
                Row {
                    Text(pokemonCombat.pokemonA)
                    Text("VS")
                    Text(pokemonCombat.pokemonB)
                }
                Button(onClick = {onDismissDialog()}) {
                    Text("A luchar!")
                }
            }

        }
    }
}