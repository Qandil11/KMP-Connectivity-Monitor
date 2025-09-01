package com.qandil.kmpconnectivity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Main(factory: ConnectivityMonitorFactory) {
    MyApplicationTheme {

        val monitor = remember(factory) { factory.create() }
        val status by monitor.status.collectAsState(ConnectivityStatus.Unavailable)

        LaunchedEffect(Unit) { monitor.start() }
        DisposableEffect(Unit) { onDispose { monitor.stop() } }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(24.dp)
            ) {

                // Card showing current connectivity
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = when (status) {
                            ConnectivityStatus.Online -> MaterialTheme.colorScheme.primaryContainer
                            ConnectivityStatus.Offline -> MaterialTheme.colorScheme.errorContainer
                            ConnectivityStatus.Unavailable -> MaterialTheme.colorScheme.surfaceVariant
                        }
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = when (status) {
                            ConnectivityStatus.Online -> "✅ Online"
                            ConnectivityStatus.Offline -> "❌ Offline"
                            ConnectivityStatus.Unavailable -> "… Checking"
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        color = when (status) {
                            ConnectivityStatus.Online -> MaterialTheme.colorScheme.onPrimaryContainer
                            ConnectivityStatus.Offline -> MaterialTheme.colorScheme.onErrorContainer
                            ConnectivityStatus.Unavailable -> MaterialTheme.colorScheme.onSurfaceVariant
                        },
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Description text
                Text(
                    text = when (status) {
                        ConnectivityStatus.Online ->
                            "You are connected to the internet. All features are available."
                        ConnectivityStatus.Offline ->
                            "No internet connection detected. Some features may not work."
                        ConnectivityStatus.Unavailable ->
                            "Detecting connectivity status…"
                    },
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}
