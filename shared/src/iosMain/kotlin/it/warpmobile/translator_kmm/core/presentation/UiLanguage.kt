package it.warpmobile.translator_kmm.core.presentation

import it.warpmobile.translator_kmm.core.domain.launguage.Language

/**
 * @author Giuseppe Sorce
 */
actual class UiLanguage(
    actual val language: Language,
    val imageName: String
) {


//    fun toLocale(): Locale? {
//        return when (language) {
//            Language.ENGLISH -> Locale.ENGLISH
//            Language.CHINESE -> Locale.CHINESE
//            Language.FRENCH -> Locale.FRENCH
//            Language.GERMAN -> Locale.GERMAN
//            Language.ITALIAN -> Locale.ITALIAN
//            Language.JAPANESE -> Locale.JAPANESE
//            Language.KOREAN -> Locale.KOREAN
//            else -> null
//        }
//    }

    actual companion object {
        actual fun byCode(langCode: String): UiLanguage {
            return allLanguages.find { it.language.langCode == langCode }
                ?: throw IllegalArgumentException("Invalid or unsupported language code")
        }


        actual val allLanguages: List<UiLanguage>
            get() = Language.values().map { language ->
                UiLanguage(
                    language = language,
                    imageName = language.langName.lowercase()
                )
            }.sortedBy { it.language.langName }
    }
}
