package com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.db.Converters

@Entity(tableName = "tutorial_cards")
data class TutorialScreenCardDataClass(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "card_title") val cardTitle: String,
    @ColumnInfo(name = "topic_list")
    @TypeConverters(Converters::class)
    val topicList: List<String>,
    @ColumnInfo(name = "content_map")
    @TypeConverters(Converters::class)
    val contentMap: Map<String, List<String>>,
    @ColumnInfo(name = "topic_completion")
    @TypeConverters(Converters::class)
    val topicCompletion: Map<String, Boolean> = topicList.associateWith { false } // Initialize all topics as incomplete
)