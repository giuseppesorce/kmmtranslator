package it.warpmobile.translator_kmm.core.domain.utils

/**
 * @author Giuseppe Sorce
 */
fun interface DisposableHandle: kotlinx.coroutines.DisposableHandle

//fun DisposableHandle( block : () -> Unit) : kotlinx.coroutines.DisposableHandle{
//    return  object  : kotlinx.coroutines.DisposableHandle{
//        override fun dispose() {
//            block()
//        }
//
//    }
//}