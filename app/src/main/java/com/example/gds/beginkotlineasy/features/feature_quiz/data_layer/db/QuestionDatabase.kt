package com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.data.PrepopulateData
import com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.data.Question
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Question::class], version = 1)
abstract class QuestionDatabase : RoomDatabase() {

    abstract fun questionDao(): QuestionDao

    companion object {
        @Volatile
        private var INSTANCE: QuestionDatabase? = null

        fun getDatabase(context: Context): QuestionDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuestionDatabase::class.java,
                    "quiz_database"
                )
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            // Populating the database with initial data on first launch
                            CoroutineScope(Dispatchers.IO).launch {
                                val questionDao = getDatabase(context).questionDao()

                                // Check if there are any questions in the database
                                val count = questionDao.getQuestionCount()

                                Log.d("AppDatabase", "Question count: $count")
                                // If no questions exist, insert prepopulated questions
                                if (count == 0) {
                                    questionDao.insertQuestions(PrepopulateData.getQuestions())
                                }
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
