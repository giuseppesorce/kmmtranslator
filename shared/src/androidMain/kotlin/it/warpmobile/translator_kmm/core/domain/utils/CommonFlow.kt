package it.warpmobile.translator_kmm.core.domain.utils

import kotlinx.coroutines.flow.Flow

/**
 * @author Giuseppe Sorce
 */
actual class CommonFlow<T> actual constructor(
    private val flow : Flow<T>

): Flow<T> by flow