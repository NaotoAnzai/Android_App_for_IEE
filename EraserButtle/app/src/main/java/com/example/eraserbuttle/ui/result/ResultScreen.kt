// ファイルパス: ui/result/ResultScreen.kt
package com.example.eraserbuttle.ui.result

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
// hand added by unsigned note S
import androidx.compose.ui.tooling.preview.Preview // ← Previewのために追加
import androidx.compose.ui.platform.LocalContext // ← プレビューのために追加
import com.example.eraserbuttle.ui.theme.EraserButtleTheme // ← Themeのために追加
// hand added by unsigned note F

@Composable
fun ResultScreen(navController: NavController, score: Int) {
    // TODO: リザルト画面担当がここにUIを実装します。
    // とりあえず今はボタンだけ仮置きします。
    com.example.eraserbuttle.ui.shared.PlaceholderScreen(
        screenName = "リザルト画面 (スコア: $score)",
        buttonText = "スタートに戻る",
        onClick = {
            navController.navigate(com.example.eraserbuttle.navigation.Screen.Start.route) {
                popUpTo(com.example.eraserbuttle.navigation.Screen.Start.route) { inclusive = true }
            }
        }
    )
}

/**
 * ResultScreenのプレビュー表示
 */
@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    EraserButtleTheme {
        // プレビュー用に、仮のNavControllerとscoreを渡してUIの見た目を確認する
        ResultScreen(
            navController = NavController(LocalContext.current),
            score = 99800
        )
    }
}