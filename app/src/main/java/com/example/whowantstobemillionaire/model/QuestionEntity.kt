package com.example.whowantstobemillionaire.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question")
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "question")
    val question: String,
    @ColumnInfo(name = "answerA")
    val answerA: String,
    @ColumnInfo(name = "answerB")
    val answerB: String,
    @ColumnInfo(name = "answerC")
    val answerC: String,
    @ColumnInfo(name = "answerD")
    val answerD: String,
    @ColumnInfo(name = "correctAnswer")
    val correctAnswer: Int,
    @ColumnInfo(name = "level")
    val level: Int
)