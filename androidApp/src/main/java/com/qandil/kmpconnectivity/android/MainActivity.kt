package com.qandil.kmpconnectivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main(factory = com.qandil.kmpconnectivity.ConnectivityMonitorFactory(this))
        }

    }
}
