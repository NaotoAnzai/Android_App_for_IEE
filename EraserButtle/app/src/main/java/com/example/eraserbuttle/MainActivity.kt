// ファイルパス: MainActivity.kt
package com.example.eraserbuttle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.eraserbuttle.navigation.AppNavigation
import com.example.eraserbuttle.ui.theme.EraserButtleTheme
import com.unity3d.player.UnityPlayer

class MainActivity : ComponentActivity() {

    private var unityPlayer: UnityPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        unityPlayer = UnityPlayer(this)

        setContent {
            EraserButtleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // アプリ全体のナビゲーションを呼び出す
                    AppNavigation(unityPlayer)
                }
            }
        }
    }

    // TODO: ゲーム担当者がここにUnityのライフサイクル管理のコードを実装します
    // (onResume, onPause, onDestroy,など)
}