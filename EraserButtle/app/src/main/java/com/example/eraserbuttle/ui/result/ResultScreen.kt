package com.example.eraserbuttle.ui.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eraserbuttle.ui.theme.EraserButtleTheme
import com.example.eraserbuttle.navigation.Screen

@Composable
fun ResultScreen(navController: NavController, score: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB3E5FC)), // ← 水色（Material Light Blue 100）
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "スコア: $score",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {
                navController.navigate(Screen.Start.route) {
                    popUpTo(Screen.Start.route) { inclusive = true }
                }
            }) {
                Text("スタートに戻る")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    EraserButtleTheme {
        ResultScreen(
            navController = rememberNavController(),
            score = 99800
        )
    }
}
