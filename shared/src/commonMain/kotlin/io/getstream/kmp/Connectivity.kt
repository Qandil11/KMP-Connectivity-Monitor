package com.qandil.kmpconnectivity


import kotlinx.coroutines.flow.StateFlow

/** Simple cross-platform status */
enum class ConnectivityStatus { Online, Offline, Unavailable }

/** Platform monitor contract */
interface ConnectivityMonitor {
    val status: StateFlow<ConnectivityStatus>
    fun start()
    fun stop()
}

/** expect a factory provided by each platform */
expect class ConnectivityMonitorFactory {
    fun create(): ConnectivityMonitor
}
