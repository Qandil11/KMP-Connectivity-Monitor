package com.qandil.kmpconnectivity


import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AndroidConnectivityMonitor(
    private val context: Context
) : ConnectivityMonitor {

    private val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    private val _status = MutableStateFlow(ConnectivityStatus.Unavailable)
    override val status: StateFlow<ConnectivityStatus> = _status

    private val scope = CoroutineScope(Dispatchers.Main.immediate)

    private val callback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) = updateNow()
        override fun onLost(network: Network) = updateNow()
        override fun onCapabilitiesChanged(network: Network, nc: NetworkCapabilities) = updateNow()
    }

    private fun updateNow() {
        val active = cm.activeNetwork
        val caps = cm.getNetworkCapabilities(active)
        val online =
            caps?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true &&
                    caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        scope.launch { _status.value = if (online) ConnectivityStatus.Online else ConnectivityStatus.Offline }
    }

    override fun start() {
        updateNow()
        val req = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        cm.registerNetworkCallback(req, callback)
    }

    override fun stop() {
        runCatching { cm.unregisterNetworkCallback(callback) }
    }
}

actual class ConnectivityMonitorFactory(private val context: Context) {
    actual fun create(): ConnectivityMonitor = AndroidConnectivityMonitor(context)
}
