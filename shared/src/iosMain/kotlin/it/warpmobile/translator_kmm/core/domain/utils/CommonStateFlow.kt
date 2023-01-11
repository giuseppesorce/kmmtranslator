package it.warpmobile.translator_kmm.core.domain.utils


import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.StateFlow

/**
 * @author Giuseppe Sorce
 */
actual open class CommonStateFlow<T> actual constructor(private val flow: StateFlow<T>) : CommonFlow<T>(flow ), StateFlow<T> {


    override val replayCache: List<T>
        get() = flow.replayCache


    override  val value: T
        get() = flow.value


    override suspend fun collect(collector: FlowCollector<T>): Nothing {
       flow.collect(collector)
    }

}