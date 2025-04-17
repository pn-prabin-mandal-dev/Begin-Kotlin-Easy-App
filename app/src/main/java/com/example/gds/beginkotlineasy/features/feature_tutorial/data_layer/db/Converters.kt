package com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.db

import android.util.Log
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {

    private val gson = Gson()

    // Convert List<String> to JSON string
    @TypeConverter
    fun fromTopicList(topicList: List<String>): String {
        Log.d("Converters", "Serializing topic list: $topicList")
        return gson.toJson(topicList)
    }

    // Convert JSON string to List<String>
    @TypeConverter
    fun toTopicList(topicListString: String): List<String> {
        val type: Type = object : TypeToken<List<String>>() {}.type
        val topicList = gson.fromJson<List<String>>(topicListString, type)
        Log.d("Converters", "Deserializing topic list: $topicList")
        return topicList
    }

    // Convert Map<String, List<String>> to JSON string
    @TypeConverter
    fun fromContentMap(contentMap: Map<String, List<String>>): String {
        Log.d("Converters", "Serializing content map: $contentMap")
        return gson.toJson(contentMap)
    }

    // Convert JSON string to Map<String, List<String>>
    @TypeConverter
    fun toContentMap(contentMapString: String): Map<String, List<String>> {
        val type: Type = object : TypeToken<Map<String, List<String>>>() {}.type
        val contentMap = gson.fromJson<Map<String, List<String>>>(contentMapString, type)
        Log.d("Converters", "Deserializing content map: $contentMap")
        return contentMap
    }

    // Convert Map<String, Boolean> to JSON string
    @TypeConverter
    fun fromTopicCompletion(topicCompletion: Map<String, Boolean>): String {
        Log.d("Converters", "Serializing topic completion: $topicCompletion")
        return gson.toJson(topicCompletion)
    }

    // Convert JSON string to Map<String, Boolean>
    @TypeConverter
    fun toTopicCompletion(topicCompletionString: String): Map<String, Boolean> {
        val type: Type = object : TypeToken<Map<String, Boolean>>() {}.type
        val topicCompletion = gson.fromJson<Map<String, Boolean>>(topicCompletionString, type)
        Log.d("Converters", "Deserializing topic completion: $topicCompletion")
        return topicCompletion
    }
}