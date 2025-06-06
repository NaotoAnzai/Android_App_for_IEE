# Android Native + Unity Library 開発プロジェクト

## 🎯 開発方針

本プロジェクトでは、**Android Studio をメイン開発環境**とし、**Unity を Android ライブラリ（.aar）として組み込む**形式で開発を行います。  
ネイティブコード（Java/Kotlin）を中心に開発し、Unity は 3D/AR/VR コンテンツなどの描画部分で使用します。

---

## 🧰 開発に必要なもの

- Android Studio（Electric Eel 以上推奨）
- Unity Hub
- Unity（例: 2022.3.Xf1）  
  インストール時は必ず「Android Build Support」＋「Android SDK & NDK Tools」「OpenJDK」を含めてください。
- Git

---

## 📦 セットアップ手順

### ✅ Android Studio プロジェクトを準備

1. Android Studio で新規プロジェクトを作成（例: Empty Activity）
2. `app/libs/` ディレクトリを作成（Unity の .aar ファイルをここに入れます）

---

### ✅ Unity ライブラリを作成する方法

1. Unity Hub で新規プロジェクト作成（テンプレート：2D or 3D）
2. プロジェクトを開く
3. `File > Build Settings` を開き、`Platform` を Android に切り替える
4. `Export as Android Library (.aar)` にチェックし、`Build` を押す
5. `Temp/gradleOut/unityLibrary.aar` が出力される

---

### ✅ Android Studio に組み込む

1. `app/libs/unityLibrary.aar` をコピー
2. `build.gradle` に以下を追加：

```gradle
repositories {
    flatDir {
        dirs 'libs'
    }
}

dependencies {
    implementation(name: 'unityLibrary', ext: 'aar')
}
