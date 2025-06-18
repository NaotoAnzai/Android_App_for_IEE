// ファイルパス: ui/start/StartScreen.kt
package com.example.eraserbuttle.ui.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource // これをインポート
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eraserbuttle.R // Rクラス（リソースIDを解決するため）をインポート
import com.example.eraserbuttle.navigation.Screen
import com.example.eraserbuttle.ui.theme.EraserButtleTheme
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.animation.core.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.SolidColor

@Composable
fun StartScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // ★★★ ここを修正 ★★★
        // res/drawable/bunbougu_keshigomu.png を背景画像として使用
        Image(
            painter = painterResource(id = R.drawable.bunbougu_keshigomu), // ★R.drawable.bunbougu_keshigomu に変更★
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // 画面に合わせて画像をトリミングして表示
        )

        // 背景にオーバーレイする半透明のグラデーション
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Black.copy(alpha = 0.3f), Color.Black.copy(alpha = 0.7f))
                    )
                )
        )

        val alphaAnimation by animateFloatAsState(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 2000,
                easing = LinearEasing
            ), label = "alphaAnimation"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .alpha(alphaAnimation),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "ERASER BUTTLE",
                fontSize = 56.sp,
                color = Color.White,
                fontWeight = FontWeight.Black,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .padding(top = 80.dp, bottom = 40.dp)
                    .border(2.dp, Color.White.copy(alpha = 0.5f))
                    .padding(horizontal = 24.dp, vertical = 12.dp)
            )

            Button(
                onClick = { navController.navigate(Screen.Game.route) },
                modifier = Modifier
                    .width(300.dp)
                    .height(70.dp)
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE57373).copy(alpha = 0.8f),
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 2.dp
                )
            ) {
                Text(text = "ゲームスタート", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            }

            Button(
                onClick = { navController.navigate(Screen.Option.route)/* TODO: オプション画面への遷移処理を記述 */ },
                modifier = Modifier
                    .width(250.dp)
                    .height(60.dp)
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF64B5F6).copy(alpha = 0.8f),
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 2.dp
                )
            ) {
                Text(text = "オプション", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    EraserButtleTheme {
        StartScreen(
            navController = NavController(LocalContext.current)
        )
    }
}