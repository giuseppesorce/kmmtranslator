package it.warpmobile.translator_kmm.translate.domain.translate

import it.warpmobile.translator_kmm.core.domain.launguage.Language
import it.warpmobile.translator_kmm.core.domain.utils.Resource
import it.warpmobile.translator_kmm.translate.domain.history.HistoryDataSource
import it.warpmobile.translator_kmm.translate.domain.history.HistoryItem

/**
 * @author Giuseppe Sorce
 */
class Translate(

    private val client: TranslateClient,
    private val historyDataSource: HistoryDataSource
) {
    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language

    ): Resource<String> {
        return try {

            val translatedText = client.translate(fromLanguage, fromText, toLanguage)

            historyDataSource.insertHistoryItem(
                HistoryItem(
                    id = null,
                    fromLanguageCode = fromLanguage.langCode,
                    toLanguageCode = toLanguage.langCode,
                    fromText = fromText,
                    toText = translatedText


                )
            )
            Resource.Success(translatedText)

        } catch (e: TranslateExtception) {
            e.printStackTrace()
            Resource.Error(e)
        }
    }
}