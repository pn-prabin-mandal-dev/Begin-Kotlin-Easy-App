package com.example.gds.beginkotlineasy.features.feature_quiz.appliction_layer


import com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.data.Question


data class QuestionState(
    val easyScore: Int = 0, // Score for Easy difficulty
    val mediumScore: Int = 0, // Score for Medium difficulty
    val hardScore: Int = 0, // Score for Hard difficulty
    val easyProgress: Float = 0f, // Progress for Easy difficulty
    val mediumProgress: Float = 0f, // Progress for Medium difficulty
    val hardProgress: Float = 0f, // Progress for Hard difficulty
    val lastAttempted: Long = System.currentTimeMillis(), // Timestamp of the last attempt
    val averageScore: Float = 0f, // Average score across all difficulties
    val isQuizCompleted: Boolean = false, // Whether the quiz is completed
    val userAnswers: Map<Question, Pair<String, Boolean>> = emptyMap() // Tracks user answers (question -> selected option and correctness)
)