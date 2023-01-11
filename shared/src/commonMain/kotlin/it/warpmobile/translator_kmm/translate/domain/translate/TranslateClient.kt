package it.warpmobile.translator_kmm.translate.domain.translate

import it.warpmobile.translator_kmm.core.domain.launguage.Language

/**
 * @author Giuseppe Sorce
 */
interface TranslateClient {

    suspend fun translate(
        fromLanguage: Language,
        fromText : String,
        toLanguage: Language
    ) : String
}