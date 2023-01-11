package it.warpmobile.translator_kmm.core.domain.utils

import kotlinx.coroutines.flow.MutableStateFlow

/**
 * @author Giuseppe Sorce
 */
class IOSMutableStateFlow<T>( initialValue : T) : CommonMutableStateFlow<T>(
    MutableStateFlow(initialValue)
)