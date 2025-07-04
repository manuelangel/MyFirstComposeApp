package com.example.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirstcomposeapp.components.MyBadgeBox
import com.example.myfirstcomposeapp.components.MyCard
import com.example.myfirstcomposeapp.components.MyCustomDialog
import com.example.myfirstcomposeapp.components.MyDateDialog
import com.example.myfirstcomposeapp.components.MyDialog
import com.example.myfirstcomposeapp.components.MyDivider
import com.example.myfirstcomposeapp.components.MyFAB
import com.example.myfirstcomposeapp.components.MyModalDrawer
import com.example.myfirstcomposeapp.components.MyNavigationBar
import com.example.myfirstcomposeapp.components.MyTimePicker
import com.example.myfirstcomposeapp.components.MyTopAppBar
import com.example.myfirstcomposeapp.components.model.PokemonCombat
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                var showDialog by remember { mutableStateOf(false) }
                val pokemonCombat = PokemonCombat("Pikachu", "Raichu")

                MyCustomDialog(
                    showDialog = showDialog,
                    pokemonCombat = pokemonCombat,
                    onDismissDialog = { showDialog = false })

                MyModalDrawer(content = {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
                        floatingActionButton = { MyFAB(onClick = { showDialog = true }) },
                        floatingActionButtonPosition = FabPosition.End,
                        bottomBar = { MyNavigationBar() }
                    ) { innerPadding ->
                        MyDivider(
                            modifier = Modifier
                                .padding(innerPadding)
                        )
                    }
                }, drawerState = drawerState)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name! manu",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        Greeting("Android")
    }
}