package com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.db

import com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.data.Question


class QuestionRepository(private val questionDao: QuestionDao) {

    suspend fun insertQuestions(questions: List<Question>) {
        questionDao.insertQuestions(questions)
    }

    suspend fun getQuestionsByDifficulty(difficulty: String, count: Int): List<Question> {
        /*Log.d("QuestionRepository", "Fetching questions for difficulty: $difficulty, count: $count")
        val questions = questionDao.getQuestionsByDifficulty(difficulty, count)
        Log.d("QuestionRepository", "Fetched ${questions.size} questions.")
        return questions*/

//         for randomly question
        // Fetch all questions for the selected difficulty level
        val allQuestions = questionDao.getQuestionsByDifficulty(difficulty)

        // Randomly select a subset of questions
        return allQuestions.shuffled().take(count)
    }

    suspend fun getQuestionCount(): Int {
        return questionDao.getQuestionCount()
    }
}