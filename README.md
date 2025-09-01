# KMP Connectivity Monitor
[![Build (Android + Shared iOS)](https://github.com/Qandil11/KMP-Connectivity-Monitor/actions/workflows/build.yml/badge.svg)](https://github.com/Qandil11/KMP-Connectivity-Monitor/actions/workflows/build.yml)

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
<img width="1080" height="2400" alt="Screenshot_20250901_220357" src="https://github.com/user-attachments/assets/92397246-3c1c-4419-bd47-6e7b2b4cbce0" />

---<img width="1080" height="2400" alt="Screenshot_20250901_220414" src="https://github.com/user-attachments/assets/10bfdffc-2150-40c1-be2a-f1b145bdafe2" />


## Architecture

