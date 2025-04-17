package com.example.gds.beginkotlineasy.core.navigation

import kotlinx.serialization.Serializable

sealed class Routes() {

    @Serializable
    object BeginKotlinEasy: Routes()

    @Serializable
    object Setting: Routes()

    @Serializable
    object ProgramAndSyntax: Routes()
    @Serializable
    object Syntax: Routes()

    // ============= Tutorial ========================
    @Serializable
    object Tutorial: Routes()

    @Serializable
    data class TutorialDetailsActivity(val title: String)

    @Serializable
    object InterviewQuestion: Routes()

    // ============== Quiz ============================
    @Serializable
    object Quiz: Routes()

    @Serializable
    data class QuizQuestionScreen( // Route for the QuizQuestionScreen
        val difficultyLevel: String, // Difficulty level
        val questionNumber: Int // Number of questions
    )

    @Serializable
    data class ResultScreen( // Route for the ResultScreen
        val difficultyLevel: String // Difficulty level
    )
}