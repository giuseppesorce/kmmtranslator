package it.warpmobile.translator_kmm.translate.data.local

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import it.warpmobile.translator_kmm.database.TranslateDatabase

/**
 * @author Giuseppe Sorce
 */
actual class DatabaseDriverFactory(
    private val context: Context
) {

    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(TranslateDatabase.Schema, context, "translate.db")
    }
}