// ファイルパス: bridge/UnityBridge.kt
package com.example.eraserbuttle.bridge

import androidx.navigation.NavController

object UnityBridge {
    var navController: NavController? = null
    var onGameFinished: ((Int) -> Unit)? = null

    /**
     * UnityのC#コードからこのメソッドを呼び出す (ゲーム担当者が実装)
     * @param score ゲームのスコア
     */
    @JvmStatic
    fun onGameFinished(score: Int) {
        // メインスレッドで画面遷移を実行する処理を、後でAppNavigation.ktに書く
        onGameFinished?.invoke(score)
    }
}