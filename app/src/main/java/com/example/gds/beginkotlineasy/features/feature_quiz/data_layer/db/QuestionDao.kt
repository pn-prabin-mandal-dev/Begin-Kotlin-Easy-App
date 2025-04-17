package com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.db
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.data.Question

@Dao
interface QuestionDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<Question>)

    // Fetch questions based on difficulty level and limit the count
    /*@Query("SELECT * FROM questions WHERE difficulty = :difficulty LIMIT :count")
    suspend fun getQuestionsByDifficulty(difficulty: String, count: Int): List<Question>*/
    // for randomly Questions
    @Query("SELECT * FROM questions WHERE difficulty = :difficulty")
    suspend fun getQuestionsByDifficulty(difficulty: String): List<Question>

    @Query("SELECT COUNT(*) FROM questions WHERE difficulty = :difficulty")
    suspend fun getQuestionCountByDifficulty(difficulty: String): Int

    // Get the total number of questions in the database
    @Query("SELECT COUNT(*) FROM questions")
    suspend fun getQuestionCount(): Int

}