package com.example.whowantstobemillionaire.di

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Room
import androidx.room.migration.AutoMigrationSpec
import com.example.whowantstobemillionaire.room.AppDataBase
import com.example.whowantstobemillionaire.room.QuestionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "questions.db"
        )
            .createFromAsset("database/question.db")
            .build()
    }

    @Provides
    fun provideQuestionDao(appDataBase: AppDataBase): QuestionDao {
        return appDataBase.questionDao()
    }
}