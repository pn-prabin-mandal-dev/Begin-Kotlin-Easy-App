package com.example.gds.beginkotlineasy.features.feature_tutorial.appliction_layer

import com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.model.TutorialScreenCardDataClass


data class TutorialProgressState(
    val tutorialCards: List<TutorialScreenCardDataClass>,
    val overallProgress: Float, // Overall progress of the app (0.0 to 1.0)
    val currentTopicIndices: Map<Int, Int> = emptyMap() // Map<CardId, CurrentTopicIndex>
) {
    // Calculate the progress of a specific tutorial card
    fun getCardProgress(card: TutorialScreenCardDataClass): Float {
        val completedTopics = card.topicCompletion.values.count { it }
        val totalTopics = card.topicList.size
        return if (totalTopics == 0) 0f else completedTopics.toFloat() / totalTopics
    }

    // Calculate the overall progress of the app
    fun calculateOverallProgress(): Float {
        val totalTopics = tutorialCards.sumOf { it.topicList.size }
        val completedTopics = tutorialCards.sumOf { card ->
            card.topicCompletion.values.count { it }
        }
        return if (totalTopics == 0) 0f else completedTopics.toFloat() / totalTopics
    }
}