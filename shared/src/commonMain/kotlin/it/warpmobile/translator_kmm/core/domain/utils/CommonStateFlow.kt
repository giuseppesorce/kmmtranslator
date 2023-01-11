package it.warpmobile.translator_kmm.core.domain.utils

import kotlinx.coroutines.flow.StateFlow

/**
 * @author Giuseppe Sorce
 */

expect class CommonStateFlow<T>(flow: StateFlow<T>): StateFlow<T>


fun <T> StateFlow<T>.toCommonStateFlow() = CommonStateFlow(this)