package com.example.gds.beginkotlineasy.features.feature_tutorial.appliction_layer

sealed class TutorialProgressEvent {
    object LoadTutorials : TutorialProgressEvent() // Add this event
    data class MarkTopicCompleted(
        val cardId: Int,
        val topic: String
    ) : TutorialProgressEvent()
}