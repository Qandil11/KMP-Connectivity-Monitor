package com.qandil.kmpconnectivity

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController { Main(factory = com.qandil.kmpconnectivity.ConnectivityMonitorFactory())
}