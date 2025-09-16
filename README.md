# KMP‑Connectivity‑Monitor

![Build (Android + Shared iOS)](https://github.com/Qandil11/KMP-Connectivity-Monitor/actions/workflows/android-shared-ios-build.yml/badge.svg)
![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)
![Kotlin](https://img.shields.io/badge/Kotlin-MultiPlatform-blue.svg)

A Kotlin Multiplatform (KMP) library + demo that lets you observe **real‑time connectivity status** (online / offline / unavailable) from shared code, for **Android + iOS**.  

---

## 🚀 Why It Matters

Applications often fail unpredictably when network connectivity changes.  
This library provides a simple, lightweight, tested solution so that any KMP app can handle connectivity smoothly without platform‑specific code duplication.

---

## ✨ Features

- Unified `ConnectivityMonitor` interface in `commonMain`  
- Real‑time status updates: `Online` / `Offline` / `Unavailable`  
- Minimal API surface (`start()`, `stop()`, + `StateFlow<ConnectivityStatus>`)  
- Demo screen using Compose Multiplatform included  
- No CocoaPods required for iOS usage  

---

## 📸 Screenshot & Demo

![Demo Screenshot 1](./assets/screenshot1.png)  
![Demo Screenshot 2](./assets/screenshot2.png)

> 🎬 [YouTube Demo](https://www.youtube.com/@QandilAndroidAI) _(if available)_

---

## 🧩 Usage Example

```kotlin
// In commonMain or shared module
val monitor = ConnectivityMonitor()  
monitor.observe().collect { status ->
    when (status) {
        ConnectivityStatus.Online -> // do something  
        ConnectivityStatus.Offline -> // show offline UI  
        ConnectivityStatus.Unavailable -> // handle unknown state  
    }
}
```

---

## ⚙️ Quickstart

```bash
git clone https://github.com/Qandil11/KMP-Connectivity-Monitor.git
cd KMP-Connectivity-Monitor

# For Android
./gradlew :androidApp:installDebug

# For iOS (Xcode / SwiftUI Preview)
open iosApp/ and build in Xcode

# Shared module usage:
Include dependency in your KMP project:
```

```kotlin
// in shared module build.gradle.kts
implementation("com.github.Qandil11:KMP‑Connectivity‑Monitor:<latest‑tag>")
```

---

## 🛠 Tech Stack

- Kotlin Multiplatform (commonMain, Android, iOS)  
- StateFlow / Coroutines  
- Compose Multiplatform demo screen  
- Native Android APIs (ConnectivityManager) & iOS Reachability (SCNetworkReachability)  

---

## 📁 Project Structure

```
KMP‑Connectivity‑Monitor/
  ├─ androidApp/
  ├─ iosApp/
  ├─ shared/
  ├─ assets/
  ├─ .github/ workflows
  └─ README.md
```

---

## 🔗 Links & Recognition

- GitHub Repo: https://github.com/Qandil11/KMP‑Connectivity‑Monitor  
- Stars: 9+  
- Blog / Dev.to Post: [Your article link here]  
- YouTube Demo: [Your video link if available]  

---

## 📌 License

MIT License
