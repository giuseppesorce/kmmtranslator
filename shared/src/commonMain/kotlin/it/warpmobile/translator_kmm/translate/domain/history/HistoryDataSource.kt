   package it.warpmobile.translator_kmm.translate.domain.history

import it.warpmobile.translator_kmm.core.domain.utils.CommonFlow

/**
 * @author Giuseppe Sorce
 */
interface HistoryDataSource {

    fun getHistory() : CommonFlow<List<HistoryItem>>

    suspend fun insertHistoryItem(item : HistoryItem)

}