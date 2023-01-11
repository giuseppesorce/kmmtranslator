package it.warpmobile.translator_kmm.translate.data.translate

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.errors.*
import it.warpmobile.translator_kmm.NetworkConstants
import it.warpmobile.translator_kmm.core.domain.launguage.Language
import it.warpmobile.translator_kmm.translate.domain.translate.TranslateClient
import it.warpmobile.translator_kmm.translate.domain.translate.TranslateError
import it.warpmobile.translator_kmm.translate.domain.translate.TranslateExtception

/**
 * @author Giuseppe Sorce
 */
class KtorTranslateClient(

    private val httpClient: HttpClient
) : TranslateClient {
    override suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String {
        val result = try {
            httpClient.post {
                url(NetworkConstants.BASE_URL + "/translate")
                contentType(ContentType.Application.Json)
                setBody(
                    TranslateDto(
                        textToTranslate = fromText,
                        sourceLanguageCode = fromLanguage.langCode,
                        targetLanguageCode = toLanguage.langCode

                    )
                )
            }

        } catch (e: IOException) {
            throw TranslateExtception(TranslateError.SERVICE_UNAVAILABLE)
        }
        when (result.status.value) {
            in 200..299 -> Unit
            500 -> throw  TranslateExtception(TranslateError.SERVER_ERROR)
            in 400..499 -> throw  TranslateExtception(TranslateError.CLIENT_ERROR)
            else -> throw  TranslateExtception(TranslateError.UNKNOWN_ERROR)
        }

        return try {
            result.body<TranslatedDto>().translatedText
        } catch (e: Exception) {
            throw  TranslateExtception(TranslateError.SERVER_ERROR)
        }

    }

}
