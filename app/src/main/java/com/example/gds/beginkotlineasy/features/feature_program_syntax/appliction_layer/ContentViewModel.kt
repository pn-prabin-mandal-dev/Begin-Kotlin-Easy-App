package com.example.gds.beginkotlineasy.features.feature_program_syntax.appliction_layer

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.db.ContentRepository
import com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.model.ContentEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/* Add a StateFlow to track whether the data has been loaded:
* This file manages the UI-related data and ensures data is loaded before rendering.
 */
class ContentViewModel(private val repository: ContentRepository, application: Application) : AndroidViewModel(application) {

    val programData: StateFlow<List<ContentEntity>> = repository.programData
    val syntaxData: StateFlow<List<ContentEntity>> = repository.syntaxData

    // Track whether data has been loaded
    private val _isDataLoaded = MutableStateFlow(false)
    val isDataLoaded: StateFlow<Boolean> = _isDataLoaded

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            try {
                // Collect programData and syntaxData
                programData.collect { programs ->
                    syntaxData.collect { syntax ->
                        // Set isDataLoaded to true as soon as data is collected
                        _isDataLoaded.value = true
                        Log.d("ContentViewModel", "Data loaded successfully.")
                        Log.d("ContentViewModel", "Program Data: $programs")
                        Log.d("ContentViewModel", "Syntax Data: $syntax")
                    }
                }
            } catch (e: Exception) {
                Log.e("ContentViewModel", "Error loading data: ${e.message}")
            }
        }
    }

    fun logAllContent() {
        viewModelScope.launch {
            programData.collect { programData ->
                Log.d("ContentViewModel", "Program Data: $programData")
            }
            syntaxData.collect { syntaxData ->
                Log.d("ContentViewModel", "Syntax Data: $syntaxData")
            }
        }
    }
}