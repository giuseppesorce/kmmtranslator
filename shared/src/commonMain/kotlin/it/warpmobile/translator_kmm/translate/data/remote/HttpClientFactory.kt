package it.warpmobile.translator_kmm.translate.data.remote

import io.ktor.client.*

/**
 * @author Giuseppe Sorce
 */
expect class HttpClientFactory {

     fun create(): HttpClient
}