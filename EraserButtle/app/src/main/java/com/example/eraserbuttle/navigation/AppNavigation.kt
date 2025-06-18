// ファイルパス: navigation/AppNavigation.kt
package com.example.eraserbuttle.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.eraserbuttle.bridge.UnityBridge
import com.example.eraserbuttle.ui.game.GameScreen
import com.example.eraserbuttle.ui.result.ResultScreen
import com.example.eraserbuttle.ui.start.StartScreen
import com.example.eraserbuttle.ui.option.OptionScreen
import com.unity3d.player.UnityPlayer

@Composable
fun AppNavigation(unityPlayer: UnityPlayer?) {
    val navController = rememberNavController()

    // UnityブリッジにNavControllerを渡して、いつでも遷移できるようにする
    UnityBridge.navController = navController
    UnityBridge.onGameFinished = { score ->
        // ゲームが終了したらリザルト画面に遷移
        navController.navigate(Screen.Result.createRoute(score)) {
            popUpTo(Screen.Game.route) { inclusive = true }
        }
    }

    NavHost(navController = navController, startDestination = Screen.Start.route) {
        composable(Screen.Start.route) {
            StartScreen(navController = navController)
        }

        composable(Screen.Game.route) {
            GameScreen(unityPlayer)
        }

        composable(
            route = Screen.Result.route,
            arguments = listOf(navArgument("score") { type = NavType.IntType })
        ) { backStackEntry ->
            val score = backStackEntry.arguments?.getInt("score") ?: 0
            ResultScreen(navController = navController, score = score)
        }

        composable(Screen.Option.route) {
            OptionScreen(navController = navController)
        }
    }
}