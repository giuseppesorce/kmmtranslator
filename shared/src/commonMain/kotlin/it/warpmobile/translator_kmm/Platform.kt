package it.warpmobile.translator_kmm

interface Platform {
    val name: String
    val home: String
}

expect fun getPlatform(): Platform