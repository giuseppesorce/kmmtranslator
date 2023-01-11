package it.warpmobile.translator_kmm.core.domain.utils


import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * @author Giuseppe Sorce
 */
actual open class CommonFlow<T> actual constructor(private val flow: Flow<T>) : Flow<T> by flow {

    fun subscribe(
        coroutineScope: CoroutineScope,
        dispatcher: CoroutineDispatcher,
        onCollect: (T) -> Unit

    ) : DisposableHandle {

        val job = coroutineScope.launch(dispatcher) {
            flow.collect(onCollect)

        }
        return DisposableHandle { job.cancel() }

    }

}