package it.warpmobile.translator_kmm.translate.data.local

import com.squareup.sqldelight.db.SqlDriver

/**
 * @author Giuseppe Sorce
 */
expect class DatabaseDriverFactory {

    fun create() : SqlDriver
}