package it.warpmobile.translator_kmm.translate.domain.translate

/**
 * @author Giuseppe Sorce
 */
enum class TranslateError {

    SERVICE_UNAVAILABLE,
    CLIENT_ERROR,
    SERVER_ERROR,
    UNKNOWN_ERROR
}

class TranslateExtception(var error: TranslateError) : Exception(
     "An error occurred when translating: $error"
)