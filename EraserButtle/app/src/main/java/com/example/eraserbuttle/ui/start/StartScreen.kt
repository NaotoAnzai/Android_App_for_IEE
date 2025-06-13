package com.example.eraserbuttle.ui.start

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eraserbuttle.navigation.Screen // Screenクラスをインポート
import com.example.eraserbuttle.ui.theme.EraserButtleTheme
import androidx.compose.ui.platform.LocalContext

@Composable
fun StartScreen(navController: NavController) {
    // 画面全体を占めるBoxコンテナ
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // 全体の配置を制御するColumn
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally, // 横方向の中央揃え
            verticalArrangement = Arrangement.SpaceBetween // 要素を上下に均等配置
        ) {
            // 1. ゲームタイトル（上部中央）
            // Spacerで上部に少し余白を作るか、paddingで直接指定
            Spacer(modifier = Modifier.height(64.dp)) // 上部の余白
            Text(
                text = "EraserButtle",
                fontSize = 48.sp,
                // Modifierをつけず、ColumnのhorizontalAlignmentで中央寄せされる
            )
            Spacer(modifier = Modifier.weight(1f)) // タイトルと開始ボタンの間にスペースを柔軟に確保

            // 2. ゲーム開始ボタン（真ん中）
            Button(
                onClick = { navController.navigate(Screen.Game.route) },
                modifier = Modifier.width(250.dp).height(60.dp) // ボタンのサイズを調整
            ) {
                Text(text = "ゲームスタート", fontSize = 24.sp)
            }

            Spacer(modifier = Modifier.weight(1f)) // 開始ボタンとオプションボタンの間にスペースを柔軟に確保

            // 3. オプションボタン（一番下）
            Button(
                onClick = { /* TODO: オプション画面への遷移処理を記述 */ },
                modifier = Modifier.width(200.dp).height(50.dp) // ボタンのサイズを調整
            ) {
                Text(text = "オプション", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(32.dp)) // 下部の余白
        }
    }
}

/**
 * StartScreenのプレビュー表示
 */
@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    EraserButtleTheme {
        // プレビュー用に、仮のNavControllerを渡してUIの見た目を確認する
        StartScreen(
            navController = NavController(LocalContext.current)
        )
    }
}