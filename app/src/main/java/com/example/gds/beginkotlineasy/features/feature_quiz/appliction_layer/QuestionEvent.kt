package com.example.gds.beginkotlineasy.features.feature_quiz.appliction_layer


import com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.data.Question


sealed class QuestionEvent { // Represents events that modify the state
    data class UpdateScore(val difficulty: String, val score: Int) : QuestionEvent() // Updates score for a difficulty level
    data class UpdateProgress(val difficulty: String, val progress: Float) : QuestionEvent() // Updates progress for a difficulty level
    data class UpdateLastAttempted(val timestamp: Long) : QuestionEvent() // Updates the last attempted timestamp
    data class SetQuizCompleted(val isCompleted: Boolean) : QuestionEvent() // Sets quiz completion status
    data class UpdateAverageScore(val average: Float) : QuestionEvent() // Updates the average score
    data class AddUserAnswer(val question: Question, val selectedOption: String, val isCorrect: Boolean) : QuestionEvent() // Adds a user's answer
}