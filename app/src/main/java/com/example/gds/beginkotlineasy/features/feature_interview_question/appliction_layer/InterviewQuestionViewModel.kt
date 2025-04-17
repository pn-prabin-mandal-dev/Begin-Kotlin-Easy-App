package com.example.gds.beginkotlineasy.features.feature_interview_question.appliction_layer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gds.beginkotlineasy.features.feature_interview_question.data_layer.data.InterviewQuestion
import com.example.gds.beginkotlineasy.features.feature_interview_question.data_layer.db.InterviewQuestionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class InterviewQuestionViewModel : ViewModel() { // Viewmodel extended makes this class eligible to be used for managing UI-related data.
    private val repository = InterviewQuestionRepository()

    private val _questions = MutableStateFlow<List<InterviewQuestion>>(emptyList())
    val questions: StateFlow<List<InterviewQuestion>> get() = _questions // questions is a read-only StateFlow that exposes the value of _questions to observers, ensuring external classes can only observe, not modify, the data.
    /*
    * The get() method is typically used in Kotlin for defining custom getters
    *    for properties, but in this case, you can directly expose
    *        the StateFlow or Flow without wrapping it in a get() method.
    * */

    init {  // init block is automatically executed when the QuestionViewModel is created.
        loadQuestions()
    }

    private fun loadQuestions() {
        viewModelScope.launch {
            _questions.value = repository.getQuestions()
        }
    }
}