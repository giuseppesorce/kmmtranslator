package it.warpmobile.translator_kmm

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }


    fun prinntHome(): String {
        return "Home new, ${platform.name}!"
    }
}