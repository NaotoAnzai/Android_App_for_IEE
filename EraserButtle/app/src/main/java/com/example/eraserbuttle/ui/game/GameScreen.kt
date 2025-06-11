// ファイルパス: ui/game/GameScreen.kt
package com.example.eraserbuttle.ui.game

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.unity3d.player.UnityPlayer
// hand added by unsigned note S
import androidx.compose.ui.tooling.preview.Preview // ← Previewのために追加
import com.example.eraserbuttle.ui.theme.EraserButtleTheme // ← Themeのために追加
// hand added by unsigned note F

@Composable
fun GameScreen(unityPlayer: UnityPlayer?) {
    // TODO: ゲーム担当者がここにAndroidViewを使ってUnityを組み込みます。
    Text("ここにUnityのゲーム画面が表示されます")
}

/**
 * GameScreenのプレビュー表示
 */
@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    EraserButtleTheme {
        // プレビューではUnityPlayerは不要なため、nullを渡してUIの見た目を確認する
        GameScreen(unityPlayer = null)
    }
}