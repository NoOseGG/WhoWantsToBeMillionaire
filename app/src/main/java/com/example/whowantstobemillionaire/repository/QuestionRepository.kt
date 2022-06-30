package com.example.whowantstobemillionaire.repository

import android.content.Context
import com.example.whowantstobemillionaire.R
import com.example.whowantstobemillionaire.model.Question
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class QuestionRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {

    suspend fun question(): Question {
        val question = context.resources.getStringArray(R.array.question)
        val answerA = context.resources.getStringArray(R.array.answer_a)
        val answerB = context.resources.getStringArray(R.array.answer_b)
        val answerC = context.resources.getStringArray(R.array.answer_c)
        val answerD = context.resources.getStringArray(R.array.answer_d)
        val correctAnswer = context.resources.getIntArray(R.array.correct_answer)

        val num = Random.nextInt(0, question.size)

        return Question(
            question = question[num],
            answerA = answerA[num],
            answerB = answerB[num],
            answerC = answerC[num],
            answerD = answerD[num],
            correctAnswer = correctAnswer[num]
        )
    }
}