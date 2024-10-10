package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ViewModel.MainViewModel
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()){
                        Button(onClick={ GlobalState.count = 0}, colors = ButtonColors(contentColor = Color.Black, containerColor = Color.Transparent, disabledContentColor = Color.Black, disabledContainerColor = Color.Transparent)){
                            Text("\uD83D\uDD04")
                        }
                    }
                    Counter(modifier = innerPadding)
                }
            }
        }
    }
}

@Composable
fun Counter( modifier: PaddingValues) {
    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("The Count is ${GlobalState.count}")
            Button( onClick = { GlobalState.count++}, colors = ButtonColors(Color.Red, Color.Black, Color.Red, Color.Black)) {
                Text("Count")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()){
        Button(onClick={ GlobalState.count = 0}, colors = ButtonColors(contentColor = Color.Black, containerColor = Color.Transparent, disabledContentColor = Color.Black, disabledContainerColor = Color.Transparent)){
            Text("\uD83D\uDD04")
        }
        }
        Counter(modifier = PaddingValues())
    }
}

object GlobalState{
    var count by mutableStateOf(0)
}
