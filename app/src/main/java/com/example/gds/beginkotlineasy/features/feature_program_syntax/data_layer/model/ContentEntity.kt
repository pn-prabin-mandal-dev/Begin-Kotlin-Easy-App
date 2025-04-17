package com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// Single Entity file for Room Database
@Entity(tableName = "content")
data class ContentEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,  // Topic Name
    val title: String, // Title Name
    val content: String, // Content (Program/Syntax)
    val type: String // Differentiates between "Program" and "Syntax"
)