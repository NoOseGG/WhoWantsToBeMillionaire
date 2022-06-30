package com.example.whowantstobemillionaire.ui.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whowantstobemillionaire.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    questionRepository: QuestionRepository
) : ViewModel() {

    val numberQuestionFlow = MutableSharedFlow<Unit>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val questionFlow = numberQuestionFlow.onEach {

    }.mapLatest {
        val question = questionRepository.question()
        question
    }.shareIn(
        viewModelScope,
        SharingStarted.Eagerly,
        replay = 1
    )

    init {
        sendAnswer()
    }

    fun sendAnswer() {
        numberQuestionFlow.tryEmit(Unit)
    }
}