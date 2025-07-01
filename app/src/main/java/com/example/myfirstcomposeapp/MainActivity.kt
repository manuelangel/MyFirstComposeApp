package com.example.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.components.MyButtons
import com.example.myfirstcomposeapp.components.MyDropDownItem
import com.example.myfirstcomposeapp.components.MyDropDownMenu
import com.example.myfirstcomposeapp.components.MyExposedDropDownMenu
import com.example.myfirstcomposeapp.components.MyFAB
import com.example.myfirstcomposeapp.components.MyIcon
import com.example.myfirstcomposeapp.components.MyImage
import com.example.myfirstcomposeapp.components.MyNetworkImage
import com.example.myfirstcomposeapp.components.MyProgress
import com.example.myfirstcomposeapp.components.MyProgressAdvance
import com.example.myfirstcomposeapp.components.MyRangeSlider
import com.example.myfirstcomposeapp.components.MySlider
import com.example.myfirstcomposeapp.components.MySliderAdvance
import com.example.myfirstcomposeapp.components.MyTextField
import com.example.myfirstcomposeapp.components.MyTextFieldParent
import com.example.myfirstcomposeapp.components.MyTexts
import com.example.myfirstcomposeapp.components.MyTopAppBar
import com.example.myfirstcomposeapp.components.ProgressAnimation
import com.example.myfirstcomposeapp.components.challenges.ChallengeOne
import com.example.myfirstcomposeapp.components.challenges.ChallengeTwo
import com.example.myfirstcomposeapp.components.layouts.ConstraintBarrier
import com.example.myfirstcomposeapp.components.layouts.ConstraintChain
import com.example.myfirstcomposeapp.components.layouts.ConstraintExampleGuide
import com.example.myfirstcomposeapp.components.layouts.MyBasicConstraintLayout
import com.example.myfirstcomposeapp.components.layouts.MyBox
import com.example.myfirstcomposeapp.components.layouts.MyColumn
import com.example.myfirstcomposeapp.components.layouts.MyComplexLayout
import com.example.myfirstcomposeapp.components.layouts.MyRow
import com.example.myfirstcomposeapp.state.MyState
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyTopAppBar() },
                    floatingActionButton = { MyFAB() },
                    floatingActionButtonPosition = FabPosition.End
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(Color.Cyan),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Esta es mi screen")
                    }
                }
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