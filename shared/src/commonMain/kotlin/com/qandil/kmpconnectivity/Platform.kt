package com.qandil.kmpconnectivity

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform