package com.example.whowantstobemillionaire.model

data class Question(
    val question: String,
    val answerA: String,
    val answerB: String,
    val answerC: String,
    val answerD: String,
    val correctAnswer: Int,
)