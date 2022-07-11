package com.example.whowantstobemillionaire.repository

import com.example.whowantstobemillionaire.mapper.toQuestion
import com.example.whowantstobemillionaire.model.Question
import com.example.whowantstobemillionaire.model.QuestionEntity
import com.example.whowantstobemillionaire.room.QuestionDao
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class QuestionRepository @Inject constructor(
    private val questionDao: QuestionDao
) {

    suspend fun questions(level: Int): Question {
        val questions = withContext(Dispatchers.Main) { questionDao.questions(level) }
        val randomNumber = (Math.random() * questions.size).toInt()
        return questions[randomNumber].toQuestion()
    }
}