package com.rahul.jott

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform