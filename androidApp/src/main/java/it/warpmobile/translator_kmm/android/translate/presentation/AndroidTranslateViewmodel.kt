package it.warpmobile.translator_kmm.android.translate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.warpmobile.translator_kmm.translate.domain.history.HistoryDataSource
import it.warpmobile.translator_kmm.translate.domain.translate.Translate
import it.warpmobile.translator_kmm.translate.presentation.TranslateEvent
import it.warpmobile.translator_kmm.translate.presentation.TranslateViewModel
import javax.inject.Inject

/**
 * @author Giuseppe Sorce
 */

@HiltViewModel
class AndroidTranslateViewmodel @Inject constructor(
    private val translate : Translate,
    private val historyDataSource: HistoryDataSource

) : ViewModel(){

    private val viewModel by lazy {
      TranslateViewModel (
          translate = translate,
          historyDataSource = historyDataSource,
          coroutineScope = viewModelScope
              )

    }

    val state = viewModel.state

    fun onEvent(event : TranslateEvent){
        viewModel.onEvent(event)
    }
}