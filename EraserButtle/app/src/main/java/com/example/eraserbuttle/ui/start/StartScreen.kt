// ファイルパス: ui/start/StartScreen.kt
package com.example.eraserbuttle.ui.start

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
// hand added by unsigned note S
import androidx.compose.ui.tooling.preview.Preview // ← Previewのために追加
import com.example.eraserbuttle.ui.theme.EraserButtleTheme // ← Themeのために追加
import androidx.compose.ui.platform.LocalContext // ← プレビューのために追加
// hand added by unsigned note F

@Composable
fun StartScreen(navController: NavController) {
    // TODO: 開始画面担当がここにUIを実装します。
    // とりあえず今はボタンだけ仮置きします。
    com.example.eraserbuttle.ui.shared.PlaceholderScreen(
        screenName = "開始画面",
        buttonText = "ゲームスタート",
        onClick = { navController.navigate(com.example.eraserbuttle.navigation.Screen.Game.route) }
    )
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