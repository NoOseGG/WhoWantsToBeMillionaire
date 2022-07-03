package com.example.whowantstobemillionaire.mapper

import com.example.whowantstobemillionaire.model.Question
import com.example.whowantstobemillionaire.model.QuestionEntity

fun QuestionEntity.toQuestion(): Question {
    return Question(
        question = question,
        answerA = answerA,
        answerB = answerB,
        answerC = answerC,
        answerD = answerD,
        correctAnswer = correctAnswer,
        numberQuestion = level
    )
}