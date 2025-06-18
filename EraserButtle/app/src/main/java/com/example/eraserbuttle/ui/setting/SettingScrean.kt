package com.example.eraserbuttle.ui.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eraserbuttle.navigation.Screen
import com.example.eraserbuttle.ui.theme.EraserButtleTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.alpha

@Composable
fun StartScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFB3E5FC), Color(0xFF0288D1))
                )
            )
            .padding(32.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 🟡 見やすくするため文字を濃い色に変更
            Text(
                text = "プレイヤー人数を選んでください",
                style = TextStyle(
                    fontSize = 26.sp,
                    color = Color(0xFF1B1B1B) // 濃いグレー
                )
            )

            val buttonModifier = Modifier
                .fillMaxWidth()
                .height(80.dp)

            val buttonTextStyle = TextStyle(
                fontSize = 24.sp,
                color = Color.White
            )

            for (i in 1..4) {
                ElevatedButton(
                    onClick = {
                        navController.navigate(Screen.Game.route)
                    },
                    modifier = buttonModifier,
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1976D2)
                    ),
                    elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // 🧑 アイコンを人数に応じて複数表示
                        repeat(i) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(horizontal = 2.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "$i 人", style = buttonTextStyle)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    EraserButtleTheme {
        StartScreen(navController = rememberNavController())
    }
}
