package com.example.whowantstobemillionaire.ui.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whowantstobemillionaire.mapper.toQuestion
import com.example.whowantstobemillionaire.model.Level
import com.example.whowantstobemillionaire.repository.HintRepository
import com.example.whowantstobemillionaire.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class GameViewModel @Inject constructor(
    questionRepository: QuestionRepository,
    hintRepository: HintRepository
) : ViewModel() {

    private var level = 0

    //get question
    val numberQuestionFlow = MutableSharedFlow<Int>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val questionFlow = numberQuestionFlow.onEach {

    }.mapLatest {
        val question = questionRepository.questions(level)
        question
    }.shareIn(
        viewModelScope,
        SharingStarted.Eagerly,
        replay = 1
    )

    //get hint
    val hintWhoCalled = MutableSharedFlow<Int>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val hintFlow = hintWhoCalled.onEach {

    }.mapLatest {
        val hint = hintRepository.hint(it)
        hint
    }.shareIn(
        viewModelScope,
        SharingStarted.Eagerly,
        replay = 1
    )

    init {
        sendAnswer()
    }

    fun sendAnswer() {
        level++
        numberQuestionFlow.tryEmit(level)
    }

    fun sendWhoCalled(id: Int) {
        hintWhoCalled.tryEmit(id)
    }
}