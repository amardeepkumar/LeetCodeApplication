package com.amardeep.leetcodepractice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amardeep.leetcodepractice.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TwoSumScreen()
                }
            }
        }
    }
}

@Composable
fun TwoSumScreen() {
    val context = LocalContext.current
    val solution = remember { Solution() }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Two Sum Example",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Button(
            onClick = {
                try {
                    val nums = intArrayOf(3,2,4)
                    val target = 6
                    val result = solution.twoSum(nums, target)
                    Toast.makeText(
                        context,
                        "Indices: [${result[0]}, ${result[1]}] - Values: ${nums[result[0]]} + ${nums[result[1]]} = $target",
                        Toast.LENGTH_LONG
                    ).show()
                } catch (e: IllegalArgumentException) {
                    Toast.makeText(
                        context,
                        "No two sum solution found",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Find Two Sum")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TwoSumPreview() {
    MyApplicationTheme {
        TwoSumScreen()
    }
}