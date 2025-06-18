// ファイルパス: MainActivity.kt
package com.example.eraserbuttle

import android.content.res.Configuration
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

    override fun onResume() {
        super.onResume()
        // アプリが前面に戻ってきたら、Unityも再開する
        unityPlayer?.resume()
    }

    override fun onPause() {
        super.onPause()
        // アプリがバックグラウンドに回ったら、Unityも一時停止する
        unityPlayer?.pause()
    }

    override fun onDestroy() {
        // Activityが破棄されるときに、Unityも終了処理を行う
        unityPlayer?.quit()
        super.onDestroy()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        unityPlayer?.windowFocusChanged(hasFocus)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        unityPlayer?.configurationChanged(newConfig)
    }
}