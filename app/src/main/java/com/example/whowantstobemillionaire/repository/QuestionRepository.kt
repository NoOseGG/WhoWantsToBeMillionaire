package com.example.whowantstobemillionaire.repository

import android.content.Context
import com.example.whowantstobemillionaire.R
import com.example.whowantstobemillionaire.mapper.toQuestion
import com.example.whowantstobemillionaire.model.Level
import com.example.whowantstobemillionaire.model.Question
import com.example.whowantstobemillionaire.model.QuestionEntity
import com.example.whowantstobemillionaire.room.QuestionDao
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class QuestionRepository @Inject constructor(
    private val questionDao: QuestionDao
) {

    suspend fun questions(level: Int): Question {
        val questions = questionDao.questions(level)
        val randomNumber = Random.nextInt(0, questions.size)
        return questions[randomNumber].toQuestion()
    }

}