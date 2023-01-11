package it.warpmobile.translator_kmm.translate.domain.history

/**
 * @author Giuseppe Sorce
 */
data class HistoryItem(

    val id: Long?,
    val fromLanguageCode : String,
    val fromText : String,
    val toLanguageCode : String,
    val toText : String
)
