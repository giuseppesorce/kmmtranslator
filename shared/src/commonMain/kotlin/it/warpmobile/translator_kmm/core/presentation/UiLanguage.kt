package it.warpmobile.translator_kmm.core.presentation

import it.warpmobile.translator_kmm.core.domain.launguage.Language

/**
 * @author Giuseppe Sorce
 */
expect class UiLanguage {
     val language: Language
    companion object {
        fun byCode(langCode: String): UiLanguage
        val allLanguages: List<UiLanguage>

    }
}