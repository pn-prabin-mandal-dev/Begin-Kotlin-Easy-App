package com.example.gds.beginkotlineasy.features.feature_quiz.appliction_layer


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.data.Question
import com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.db.QuestionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuestionViewModel(
    application: Application,
    private val repository: QuestionRepository // Repository for data operations
) : AndroidViewModel(application) {

    private val _questions = MutableStateFlow<List<Question>>(emptyList()) // Mutable list of questions
    val questions: StateFlow<List<Question>> = _questions // Exposed as immutable StateFlow

    private val _loading = MutableStateFlow(false) // Loading state
    val loading: StateFlow<Boolean> = _loading // Exposed as immutable StateFlow

    private val _state = MutableStateFlow(QuestionState()) // Mutable state
    val state: StateFlow<QuestionState> = _state // Exposed as immutable StateFlow

    // Handles events to update the state
    fun onEvent(event: QuestionEvent) {
        when (event) {
            is QuestionEvent.UpdateScore -> updateScore(event.difficulty, event.score)
            is QuestionEvent.UpdateProgress -> updateProgress(event.difficulty, event.progress)
            is QuestionEvent.UpdateLastAttempted -> updateLastAttempted(event.timestamp)
            is QuestionEvent.SetQuizCompleted -> setQuizCompleted(event.isCompleted)
            is QuestionEvent.UpdateAverageScore -> updateAverageScore(event.average)
            is QuestionEvent.AddUserAnswer -> addUserAnswer(event.question, event.selectedOption, event.isCorrect)
        }
    }

    // Updates the score for a specific difficulty level
    private fun updateScore(difficulty: String, score: Int) {
        _state.value = _state.value.copy(
            easyScore = if (difficulty == "Easy") score else _state.value.easyScore,
            mediumScore = if (difficulty == "Medium") score else _state.value.mediumScore,
            hardScore = if (difficulty == "Hard") score else _state.value.hardScore
        )
    }

    // Updates the progress for a specific difficulty level
    private fun updateProgress(difficulty: String, progress: Float) {
        Log.d("QuestionViewModel", "Updating progress for $difficulty: $progress")
        _state.value = _state.value.copy(
            easyProgress = if (difficulty == "Easy") progress else _state.value.easyProgress,
            mediumProgress = if (difficulty == "Medium") progress else _state.value.mediumProgress,
            hardProgress = if (difficulty == "Hard") progress else _state.value.hardProgress
        )
    }

    // Updates the last attempted timestamp
    private fun updateLastAttempted(timestamp: Long) {
        _state.value = _state.value.copy(lastAttempted = timestamp)
    }

    // Sets the quiz completion status
    private fun setQuizCompleted(isCompleted: Boolean) {
        _state.value = _state.value.copy(isQuizCompleted = isCompleted)
    }

    // Updates or calculates the average score
    private fun updateAverageScore(average: Float? = null) {
        val newAverage = average ?: run {
            val scores = listOf(_state.value.easyScore, _state.value.mediumScore, _state.value.hardScore)
            scores.average().toFloat() // Calculates average if no value is provided
        }
        _state.value = _state.value.copy(averageScore = newAverage)
    }

    // Adds a user's answer to the state
    private fun addUserAnswer(question: Question, selectedOption: String, isCorrect: Boolean) {
        val updatedAnswers = _state.value.userAnswers.toMutableMap().apply {
            this[question] = selectedOption to isCorrect // Maps question to selected option and correctness
        }
        _state.value = _state.value.copy(userAnswers = updatedAnswers)
    }

    // Loads questions by difficulty level
    fun loadQuestionsByDifficulty(difficulty: String, count: Int) {
        viewModelScope.launch {
            _loading.value = true // Sets loading state to true
            val loadedQuestions = repository.getQuestionsByDifficulty(difficulty, count) // Fetches questions
            _questions.value = loadedQuestions // Updates the questions list
            _loading.value = false // Sets loading state to false
        }
    }
}