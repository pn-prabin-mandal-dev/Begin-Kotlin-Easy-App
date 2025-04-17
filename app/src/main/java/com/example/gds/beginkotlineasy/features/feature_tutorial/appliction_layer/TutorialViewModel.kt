package com.example.gds.beginkotlineasy.features.feature_tutorial.appliction_layer

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.db.TutorialRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TutorialViewModel(
    private val repository: TutorialRepository
) : ViewModel() {

    // State for tutorial cards and overall progress
    private val _state = MutableStateFlow<TutorialProgressState>(
        TutorialProgressState(emptyList(), 0f)
    )
    val state: StateFlow<TutorialProgressState> get() = _state

    // State for progress (completed, remaining, percentage)
    private val _progress = MutableStateFlow(Progress(completed = 0, remaining = 10, percentage = 0.5f))
    val progress: StateFlow<Progress> = _progress.asStateFlow()

    // State for tutorials
    private val _tutorials = MutableStateFlow<List<Tutorial>>(emptyList())
    val tutorials: StateFlow<List<Tutorial>> = _tutorials.asStateFlow()

    // State for current tutorial title
    private val _currentTutorialTitle = MutableStateFlow("")
    val currentTutorialTitle: StateFlow<String> = _currentTutorialTitle.asStateFlow()

    // State for current topic index for each card
    private val _currentTopicIndices = MutableStateFlow<Map<Int, Int>>(emptyMap()) // Map<CardId, CurrentTopicIndex>
    val currentTopicIndices: StateFlow<Map<Int, Int>> get() = _currentTopicIndices.asStateFlow()

    // Load tutorials
    init {
        loadTutorials()
    }

    private fun loadTutorials() {
        viewModelScope.launch {
            Log.d("TutorialViewModel", "Initial state: ${_state.value.tutorialCards.size} cards")
            repository.getAllTutorialCards().collect { cards ->
                Log.d("TutorialViewModel", "Tutorial cards loaded: ${cards.size} cards")
                _state.update { currentState ->
                    currentState.copy(
                        tutorialCards = cards,
                        overallProgress = currentState.calculateOverallProgress()
                    )
                }

                // Update tutorials state
                _tutorials.value = cards.map { card ->
                    Tutorial(
                        id = card.id, // Include the id here
                        title = card.cardTitle,
                        topics = card.topicList.map { topic ->
                            Topic(
                                title = topic,
                                content = card.contentMap[topic]?.joinToString("\n") ?: ""
                            )
                        },
                        progress = card.topicCompletion.values.count { it }.toFloat() / card.topicList.size
                    )
                }

                // Update progress state
                val completedTopics = cards.sumOf { card ->
                    card.topicCompletion.values.count { it }
                }
                val totalTopics = cards.sumOf { card ->
                    card.topicList.size
                }
                _progress.value = Progress(
                    completed = completedTopics,
                    remaining = totalTopics - completedTopics,
                    percentage = completedTopics.toFloat() / totalTopics
                )
            }
        }
    }

    // Handle events
    fun onEvent(event: TutorialProgressEvent) {
        when (event) {
            is TutorialProgressEvent.MarkTopicCompleted -> {
                markTopicCompleted(event.cardId, event.topic)
            }
            TutorialProgressEvent.LoadTutorials -> {}
        }
    }

    // Mark a topic as completed
    private fun markTopicCompleted(cardId: Int, topic: String) {
        viewModelScope.launch {
            Log.d("TutorialViewModel", "Marking topic as completed: Card ID $cardId, Topic: $topic")
            val updatedCards = _state.value.tutorialCards.map { card ->
                if (card.id == cardId) {
                    val updatedCompletion = card.topicCompletion.toMutableMap()
                    updatedCompletion[topic] = true
                    Log.d("TutorialViewModel", "Updated completion for card ${card.cardTitle}: ${updatedCompletion[topic]}")
                    card.copy(topicCompletion = updatedCompletion)
                } else {
                    card
                }
            }

            // Update the state with the new progress
            _state.update { currentState ->
                currentState.copy(
                    tutorialCards = updatedCards,
                    overallProgress = currentState.calculateOverallProgress()
                )
            }

            // Update the repository
            repository.updateTutorialCard(updatedCards.find { it.id == cardId }!!)

            // Log the updated state
            Log.d("TutorialViewModel", "Updated state: ${_state.value.tutorialCards.size} cards")
            _state.value.tutorialCards.forEach { card ->
                Log.d("TutorialViewModel", "Card: ${card.cardTitle}, Progress: ${(_state.value.getCardProgress(card) * 100).toInt()}%")
                Log.d("TutorialViewModel", "Completion: ${card.topicCompletion}")
            }

            // Update progress state
            val completedTopics = updatedCards.sumOf { card ->
                card.topicCompletion.values.count { it }
            }
            val totalTopics = updatedCards.sumOf { card ->
                card.topicList.size
            }
            _progress.value = Progress(
                completed = completedTopics,
                remaining = totalTopics - completedTopics,
                percentage = completedTopics.toFloat() / totalTopics
            )
        }
    }

    // Get a tutorial by title
    fun getTutorial(title: String): Tutorial {
        return _tutorials.value.first { it.title == title }
    }

    // Set the current tutorial title
    fun setCurrentTutorialTitle(title: String) {
        _currentTutorialTitle.value = title
    }

    // Get the current topic index for a card
    fun getCurrentTopicIndex(cardId: Int): Int {
        return _currentTopicIndices.value[cardId] ?: 0
    }

    // Get the current topic index for a card as a StateFlow
    fun getCurrentTopicIndexFlow(cardId: Int): StateFlow<Int> {
        return _currentTopicIndices.map { indices -> indices[cardId] ?: 0 }.stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            0
        )
    }

    // Set the current topic index for a card
    fun setCurrentTopicIndex(cardId: Int, index: Int) {
        _currentTopicIndices.update { currentIndices ->
            currentIndices + (cardId to index)
        }
    }

    // Reset the current topic index for a card
    fun resetCurrentTopicIndex(cardId: Int) {
        _currentTopicIndices.update { currentIndices ->
            currentIndices - cardId
        }
    }
}

// Data classes for progress, tutorial, and topic
data class Progress(
    val completed: Int,
    val remaining: Int,
    val percentage: Float
)

data class Tutorial(
    val id: Int, // Add this field
    val title: String,
    val topics: List<Topic>,
    val progress: Float
) {
    val remainingTopics: List<String>
        get() = topics.map { it.title }
}

data class Topic(
    val title: String,
    val content: String
)