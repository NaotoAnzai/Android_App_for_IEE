// ファイルパス: ui/shared/PlaceholderScreen.kt
package com.example.eraserbuttle.ui.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eraserbuttle.ui.theme.EraserButtleTheme

/**
 * 画面の中央にテキストとボタンを配置する、汎用的なプレースホルダー画面。
 * @param screenName 画面上部に表示するテキスト。
 * @param buttonText ボタンに表示するテキスト。
 * @param onClick ボタンがクリックされたときに実行される処理。
 */
@Composable
fun PlaceholderScreen(
    screenName: String,
    buttonText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Columnを使って、要素を縦に並べます
    Column(
        // 画面全体に広げます
        modifier = modifier.fillMaxSize(),
        // 垂直方向（縦）に中央揃え
        verticalArrangement = Arrangement.Center,
        // 水平方向（横）に中央揃え
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 画面名を表示するテキスト
        Text(
            text = screenName,
            style = MaterialTheme.typography.headlineMedium
        )

        // テキストとボタンの間に16dpの間隔を空けます
        Spacer(modifier = Modifier.height(16.dp))

        // ボタン
        Button(onClick = onClick) {
            Text(text = buttonText)
        }
    }
}

/**
 * この画面自体のプレビュー（開発中に見た目を確認するため）
 */
@Preview(showBackground = true)
@Composable
fun PlaceholderScreenPreview() {
    EraserButtleTheme {
        PlaceholderScreen(
            screenName = "プレビュー画面",
            buttonText = "ボタンのテキスト",
            onClick = { /* プレビューでは何もしない */ }
        )
    }
}