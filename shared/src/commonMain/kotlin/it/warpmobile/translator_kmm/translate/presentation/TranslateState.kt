package it.warpmobile.translator_kmm.translate.presentation

import it.warpmobile.translator_kmm.core.presentation.UiLanguage
import it.warpmobile.translator_kmm.translate.domain.translate.TranslateError

/**
 * @author Giuseppe Sorce
 */
data class TranslateState(

    val fromText: String = "",
    val toText: String? = "",
    val isTranslating: Boolean = false,
    val fromLanguage: UiLanguage = UiLanguage.byCode("en"),
    val toLanguage: UiLanguage = UiLanguage.byCode("de"),
    val isChoosingFromLanguage: Boolean = false,
    val isChoosingToLanguage: Boolean = false,
    val error: TranslateError? = null,
    val history: List<UiHistoryItem> = emptyList()


)