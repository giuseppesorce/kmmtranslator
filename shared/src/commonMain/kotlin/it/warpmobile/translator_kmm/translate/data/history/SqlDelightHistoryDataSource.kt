package it.warpmobile.translator_kmm.translate.data.history

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import it.warpmobile.translator_kmm.core.domain.utils.CommonFlow
import it.warpmobile.translator_kmm.core.domain.utils.toCommonFlow
import it.warpmobile.translator_kmm.database.TranslateDatabase
import it.warpmobile.translator_kmm.translate.domain.history.HistoryDataSource
import it.warpmobile.translator_kmm.translate.domain.history.HistoryItem
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

/**
 * @author Giuseppe Sorce
 */
class SqlDelightHistoryDataSource(
    db: TranslateDatabase

) : HistoryDataSource {

    private val queries = db.translateQueries
    override fun getHistory(): CommonFlow<List<HistoryItem>> {

        return queries.getHistory().asFlow().mapToList()
            .map { history -> history.map { it.toHistoryItem() } }.toCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        queries.inserHistoryEntity(
            id = item.id,
            fromLanguageCode = item.fromLanguageCode,
            fromText = item.fromText,
            toLanguangeCode = item.toLanguageCode,
            toText = item.toText,
            timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }
}