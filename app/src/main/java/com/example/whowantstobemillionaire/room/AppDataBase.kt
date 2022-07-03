package com.example.whowantstobemillionaire.room

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.whowantstobemillionaire.model.QuestionEntity


@Database(entities = [QuestionEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun questionDao(): QuestionDao
}