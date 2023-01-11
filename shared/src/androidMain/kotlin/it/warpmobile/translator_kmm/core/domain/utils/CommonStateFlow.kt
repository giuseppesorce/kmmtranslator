package it.warpmobile.translator_kmm.core.domain.utils

import kotlinx.coroutines.flow.StateFlow

/**
 * @author Giuseppe Sorce
 */

actual class CommonStateFlow<T> actual constructor(private val flow: StateFlow<T>) : StateFlow<T> by flow
