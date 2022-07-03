package com.example.whowantstobemillionaire.repository

import android.content.Context
import com.example.whowantstobemillionaire.R
import com.example.whowantstobemillionaire.model.Level
import com.example.whowantstobemillionaire.model.Question
import com.example.whowantstobemillionaire.room.QuestionDao
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class QuestionRepository @Inject constructor(
    @ApplicationContext private val context: Context,
) {

    suspend fun question(level: Level): Question {
        when(level) {
            is Level.One -> { return levelOne() }
            is Level.Two -> { return levelTwo() }
            is Level.Three -> { return levelThree() }
            is Level.Four -> { return levelFour() }
            is Level.Five -> { return levelFive() }
            is Level.Six -> { return  levelSix() }
            is Level.Seven -> { return levelSeven() }
            is Level.Eight -> { return levelEight() }
            is Level.Nine -> { return levelNine() }
            is Level.Ten -> { return levelTen() }
        }
    }

    private fun levelOne(): Question {
        val question = context.resources.getStringArray(R.array.question_level_1)
        val answerA = context.resources.getStringArray(R.array.answer_a_level_1)
        val answerB = context.resources.getStringArray(R.array.answer_b_level_1)
        val answerC = context.resources.getStringArray(R.array.answer_c_level_1)
        val answerD = context.resources.getStringArray(R.array.answer_d_level_1)
        val correctAnswer = context.resources.getIntArray(R.array.correct_answer_level_1)

        val num = Random.nextInt(0, question.size)

        return Question(
            question = question[num],
            answerA = answerA[num],
            answerB = answerB[num],
            answerC = answerC[num],
            answerD = answerD[num],
            correctAnswer = correctAnswer[num],
            numberQuestion = 1
        )
    }

    private fun levelTwo(): Question {
        val question = context.resources.getStringArray(R.array.question_level_2)
        val answerA = context.resources.getStringArray(R.array.answer_a_level_2)
        val answerB = context.resources.getStringArray(R.array.answer_b_level_2)
        val answerC = context.resources.getStringArray(R.array.answer_c_level_2)
        val answerD = context.resources.getStringArray(R.array.answer_d_level_2)
        val correctAnswer = context.resources.getIntArray(R.array.correct_answer_level_2)

        val num = Random.nextInt(0, question.size)

        return Question(
            question = question[num],
            answerA = answerA[num],
            answerB = answerB[num],
            answerC = answerC[num],
            answerD = answerD[num],
            correctAnswer = correctAnswer[num],
            numberQuestion = 2
        )
    }

    private fun levelThree(): Question {
        val question = context.resources.getStringArray(R.array.question_level_3)
        val answerA = context.resources.getStringArray(R.array.answer_a_level_3)
        val answerB = context.resources.getStringArray(R.array.answer_b_level_3)
        val answerC = context.resources.getStringArray(R.array.answer_c_level_3)
        val answerD = context.resources.getStringArray(R.array.answer_d_level_3)
        val correctAnswer = context.resources.getIntArray(R.array.correct_answer_level_3)

        val num = Random.nextInt(0, question.size)

        return Question(
            question = question[num],
            answerA = answerA[num],
            answerB = answerB[num],
            answerC = answerC[num],
            answerD = answerD[num],
            correctAnswer = correctAnswer[num],
            numberQuestion = 3
        )
    }

    private fun levelFour(): Question {
        val question = context.resources.getStringArray(R.array.question_level_4)
        val answerA = context.resources.getStringArray(R.array.answer_a_level_4)
        val answerB = context.resources.getStringArray(R.array.answer_b_level_4)
        val answerC = context.resources.getStringArray(R.array.answer_c_level_4)
        val answerD = context.resources.getStringArray(R.array.answer_d_level_4)
        val correctAnswer = context.resources.getIntArray(R.array.correct_answer_level_4)

        val num = Random.nextInt(0, question.size)

        return Question(
            question = question[num],
            answerA = answerA[num],
            answerB = answerB[num],
            answerC = answerC[num],
            answerD = answerD[num],
            correctAnswer = correctAnswer[num],
            numberQuestion = 4
        )
    }

    private fun levelFive(): Question {
        val question = context.resources.getStringArray(R.array.question_level_5)
        val answerA = context.resources.getStringArray(R.array.answer_a_level_5)
        val answerB = context.resources.getStringArray(R.array.answer_b_level_5)
        val answerC = context.resources.getStringArray(R.array.answer_c_level_5)
        val answerD = context.resources.getStringArray(R.array.answer_d_level_5)
        val correctAnswer = context.resources.getIntArray(R.array.correct_answer_level_5)

        val num = Random.nextInt(0, question.size)

        return Question(
            question = question[num],
            answerA = answerA[num],
            answerB = answerB[num],
            answerC = answerC[num],
            answerD = answerD[num],
            correctAnswer = correctAnswer[num],
            numberQuestion = 5
        )
    }

    private fun levelSix(): Question {
        val question = context.resources.getStringArray(R.array.question_level_6)
        val answerA = context.resources.getStringArray(R.array.answer_a_level_6)
        val answerB = context.resources.getStringArray(R.array.answer_b_level_6)
        val answerC = context.resources.getStringArray(R.array.answer_c_level_6)
        val answerD = context.resources.getStringArray(R.array.answer_d_level_6)
        val correctAnswer = context.resources.getIntArray(R.array.correct_answer_level_6)

        val num = Random.nextInt(0, question.size)

        return Question(
            question = question[num],
            answerA = answerA[num],
            answerB = answerB[num],
            answerC = answerC[num],
            answerD = answerD[num],
            correctAnswer = correctAnswer[num],
            numberQuestion = 6
        )
    }

    private fun levelSeven(): Question {
        val question = context.resources.getStringArray(R.array.question_level_7)
        val answerA = context.resources.getStringArray(R.array.answer_a_level_7)
        val answerB = context.resources.getStringArray(R.array.answer_b_level_7)
        val answerC = context.resources.getStringArray(R.array.answer_c_level_7)
        val answerD = context.resources.getStringArray(R.array.answer_d_level_7)
        val correctAnswer = context.resources.getIntArray(R.array.correct_answer_level_7)

        val num = Random.nextInt(0, question.size)

        return Question(
            question = question[num],
            answerA = answerA[num],
            answerB = answerB[num],
            answerC = answerC[num],
            answerD = answerD[num],
            correctAnswer = correctAnswer[num],
            numberQuestion = 7
        )
    }

    private fun levelEight(): Question {
        val question = context.resources.getStringArray(R.array.question_level_8)
        val answerA = context.resources.getStringArray(R.array.answer_a_level_8)
        val answerB = context.resources.getStringArray(R.array.answer_b_level_8)
        val answerC = context.resources.getStringArray(R.array.answer_c_level_8)
        val answerD = context.resources.getStringArray(R.array.answer_d_level_8)
        val correctAnswer = context.resources.getIntArray(R.array.correct_answer_level_8)

        val num = Random.nextInt(0, question.size)

        return Question(
            question = question[num],
            answerA = answerA[num],
            answerB = answerB[num],
            answerC = answerC[num],
            answerD = answerD[num],
            correctAnswer = correctAnswer[num],
            numberQuestion = 8
        )
    }

    private fun levelNine(): Question {
        val question = context.resources.getStringArray(R.array.question_level_9)
        val answerA = context.resources.getStringArray(R.array.answer_a_level_9)
        val answerB = context.resources.getStringArray(R.array.answer_b_level_9)
        val answerC = context.resources.getStringArray(R.array.answer_c_level_9)
        val answerD = context.resources.getStringArray(R.array.answer_d_level_9)
        val correctAnswer = context.resources.getIntArray(R.array.correct_answer_level_9)

        val num = Random.nextInt(0, question.size)

        return Question(
            question = question[num],
            answerA = answerA[num],
            answerB = answerB[num],
            answerC = answerC[num],
            answerD = answerD[num],
            correctAnswer = correctAnswer[num],
            numberQuestion = 9
        )
    }

    private fun levelTen(): Question {
        val question = context.resources.getStringArray(R.array.question_level_10)
        val answerA = context.resources.getStringArray(R.array.answer_a_level_10)
        val answerB = context.resources.getStringArray(R.array.answer_b_level_10)
        val answerC = context.resources.getStringArray(R.array.answer_c_level_10)
        val answerD = context.resources.getStringArray(R.array.answer_d_level_10)
        val correctAnswer = context.resources.getIntArray(R.array.correct_answer_level_10)

        val num = Random.nextInt(0, question.size)

        return Question(
            question = question[num],
            answerA = answerA[num],
            answerB = answerB[num],
            answerC = answerC[num],
            answerD = answerD[num],
            correctAnswer = correctAnswer[num],
            numberQuestion = 10
        )
    }
}