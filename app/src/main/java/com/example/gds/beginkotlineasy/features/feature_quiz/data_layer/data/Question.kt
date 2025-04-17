package com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class Question(
    val question: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val correctAnswer: String,
    val difficulty: String, // Easy, Medium, Hard
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
