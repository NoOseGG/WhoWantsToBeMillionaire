package com.example.whowantstobemillionaire.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.whowantstobemillionaire.model.QuestionEntity

@Dao
interface QuestionDao {

    @Query("SELECT * FROM question WHERE level = :level")
    suspend fun questions(level: Int): List<QuestionEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQuestion(questionEntity: QuestionEntity)

}