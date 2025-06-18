package com.example.eraserbuttle.ui.option

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext // Previewのために追加
import com.example.eraserbuttle.ui.theme.EraserButtleTheme // テーマのインポート

@OptIn(ExperimentalMaterial3Api::class) // SliderStateのために必要
@Composable
fun OptionScreen(navController: NavController) {
    // 音量設定を保持するState
    // 初期値は0.5f (50%) に設定
    var volumeLevel by remember { mutableFloatStateOf(0.5f) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("オプション") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF64B5F6).copy(alpha = 0.8f),
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Scaffoldのパディングを適用
                .background(Color.LightGray.copy(alpha = 0.3f)), // 背景色
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "音量設定",
                fontSize = 24.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // 音量スライダー
            Slider(
                value = volumeLevel,
                onValueChange = { newValue ->
                    volumeLevel = newValue
                    // ★★★ ここに音量変更のロジックを記述 ★★★
                    // 例: BGMの音量をnewValueに合わせて変更する
                    // Log.d("OptionScreen", "Volume changed to: $volumeLevel")
                },
                valueRange = 0f..1f, // 0から1までの範囲
                steps = 9, // 10段階 (0, 0.1, ..., 0.9, 1)
                modifier = Modifier.padding(horizontal = 32.dp),
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(0xFF64B5F6),
                    inactiveTrackColor = Color.LightGray,
                    thumbColor = Color(0xFF64B5F6)
                )
            )

            Text(
                text = "現在の音量: ${(volumeLevel * 100).toInt()}%",
                fontSize = 18.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(48.dp))

            Button(
                onClick = { navController.popBackStack() }, // 前の画面に戻る
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE57373).copy(alpha = 0.8f),
                    contentColor = Color.White
                )
            ) {
                Text(text = "戻る", fontSize = 20.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OptionScreenPreview() {
    EraserButtleTheme {
        // PreviewではNavControllerのインスタンスを適切に渡す
        OptionScreen(navController = NavController(LocalContext.current))
    }
}