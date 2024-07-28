package com.example.basiccalculator

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccalculator.ui.theme.BasicCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicCalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var firstNumber: String by remember { mutableStateOf("") }
    var secondNumber: String by remember { mutableStateOf("") }
    val context: Context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = firstNumber,
                onValueChange = { firstNumber = it },
                label = { Text("Enter 1st Number") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
            TextField(
                value = secondNumber,
                onValueChange = { secondNumber = it },
                label = { Text("Enter 2nd Number") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 20.dp)
            )
            Button(onClick = {
                val sum = calcSum(firstNumber, secondNumber)
                Toast.makeText(context, "Sum: $sum", Toast.LENGTH_SHORT).show()
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 30.dp).height(50.dp)) {
                Text(text = "Calculate")
            }

        }
    }
}

fun calcSum(firstNumber: String, secondNumber: String): Int {
    val num1 = firstNumber.toIntOrNull() ?: 0
    val num2 = secondNumber.toIntOrNull() ?: 0
    return num1 + num2
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BasicCalculatorTheme {
        Greeting("Android")
    }
}