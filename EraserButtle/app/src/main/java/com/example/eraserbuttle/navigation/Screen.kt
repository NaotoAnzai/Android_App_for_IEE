// ファイルパス: navigation/Screen.kt
package com.example.eraserbuttle.navigation

sealed class Screen(val route: String) {
    object Start : Screen("start_screen")
    object Game : Screen("game_screen")
    // スコアを渡せるようにルートを定義
    object Result : Screen("result_screen/{score}") {
        fun createRoute(score: Int) = "result_screen/$score"
    }
    object Option : Screen("option_screen")
}