// ファイルパス: ui/game/GameScreen.kt
package com.example.eraserbuttle.ui.game

import androidx.compose.material3.Text
// hand added by unsigned note S
import androidx.compose.ui.tooling.preview.Preview // ← Previewのために追加
import com.example.eraserbuttle.ui.theme.EraserButtleTheme // ← Themeのために追加
import android.widget.FrameLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.eraserbuttle.ui.theme.EraserButtleTheme
import com.unity3d.player.UnityPlayer
// hand added by unsigned note F

@Composable
fun GameScreen(unityPlayer: UnityPlayer?) {
    // TODO: ゲーム担当者がここにAndroidViewを使ってUnityを組み込みます。
    // Text("ここにUnityのゲーム画面が表示されます")

    AndroidView(
        // modifierを適用して画面全体に広げる
        modifier = Modifier.fillMaxSize(),
        // factoryはViewを生成する場所。一度だけ呼ばれる。
        factory = { context ->
            // UnityのViewを配置するためのコンテナ(FrameLayout)を作成
            FrameLayout(context).apply {
                // 安全策：もしUnityのViewがすでに他の親に属していたら、それを解除する
                (unityPlayer?.view?.parent as? android.view.ViewGroup)?.removeView(unityPlayer?.view)

                // コンテナにUnityのViewを追加する
                addView(
                    unityPlayer?.view,
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
            }
        }
    )
}

/**
 * GameScreenのプレビュー表示
 */
@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    EraserButtleTheme {
        // プレビューではUnityPlayerは不要なため、nullを渡してUIの見た目を確認する
        //GameScreen(unityPlayer = null)
        // ↑ プレビュー時にエラーが出る場合は、仮のTextなどを表示するようにしても良い
        androidx.compose.material3.Text("Unity Game Screen Preview")
    }
}