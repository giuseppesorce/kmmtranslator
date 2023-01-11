package it.warpmobile.translator_kmm.translate.presentation

import it.warpmobile.translator_kmm.core.presentation.UiLanguage

/**
 * @author Giuseppe Sorce
 */
data class UiHistoryItem(

    val id: Long,
    val fromText: String,
    val toText: String,
    val fromLanguage: UiLanguage,
    val toLanguage: UiLanguage
)