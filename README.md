# KMP Connectivity Monitor

A tiny **Kotlin Multiplatform (KMP)** library + demo that exposes a single
`StateFlow<ConnectivityStatus>` to observe **online / offline** status from shared code.

- **Android:** uses `ConnectivityManager` network callbacks  
- **iOS:** uses `SCNetworkReachability` (no CocoaPods required)

https://github.com/Qandil11/KMP-Connectivity-Monitor

---

## Features

- Unified `ConnectivityMonitor` interface in **commonMain**
- Real-time updates: `Online` / `Offline` / `Unavailable`
- Minimal API surface (start/stop + `StateFlow`)
- Compose Multiplatform demo screen included

---

## Screenshots

---

## Architecture

