package com.franya

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform