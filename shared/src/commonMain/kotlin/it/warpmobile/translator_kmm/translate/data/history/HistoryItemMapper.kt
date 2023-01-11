package it.warpmobile.translator_kmm.translate.data.history

import database.HistoryEntity
import it.warpmobile.translator_kmm.translate.domain.history.HistoryItem

/**
 * @author Giuseppe Sorce
 */
fun HistoryEntity.toHistoryItem(): HistoryItem {

    return  HistoryItem(
        id = id,
        fromLanguageCode = fromLanguageCode,
        fromText = fromText,
        toLanguageCode = toLanguangeCode,
        toText = toText
    )
}