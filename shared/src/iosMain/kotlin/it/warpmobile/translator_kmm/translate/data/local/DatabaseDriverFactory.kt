package it.warpmobile.translator_kmm.translate.data.local

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import it.warpmobile.translator_kmm.database.TranslateDatabase

/**
 * @author Giuseppe Sorce
 */
actual class DatabaseDriverFactory(
) {

    actual fun create(): SqlDriver {
        return NativeSqliteDriver(TranslateDatabase.Schema, "translate.db")
    }
}