package it.warpmobile.translator_kmm.translate.data.remote

import io.ktor.client.*
import io.ktor.client.engine.darwin.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

/**
 * @author Giuseppe Sorce
 */
actual class HttpClientFactory {

    actual fun create(): HttpClient {
        return HttpClient(Darwin){
            install(ContentNegotiation){
                json()
            }
        }
    }
}