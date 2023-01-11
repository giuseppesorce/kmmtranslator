package it.warpmobile.translator_kmm.core.domain.utils

import kotlinx.coroutines.flow.MutableStateFlow

/**
 * @author Giuseppe Sorce
 */

actual class CommonMutableStateFlow<T> actual constructor(private val flow: MutableStateFlow<T>) : MutableStateFlow<T> by flow
