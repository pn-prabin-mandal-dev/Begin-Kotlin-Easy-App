package com.example.gds.beginkotlineasy.features.feature_quiz.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gds.beginkotlineasy.R
import com.example.gds.beginkotlineasy.core.navigation.Routes
import com.example.gds.beginkotlineasy.features.feature_quiz.appliction_layer.QuestionEvent
import com.example.gds.beginkotlineasy.features.feature_quiz.appliction_layer.QuestionViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizQuestionScreen(
    difficultyLevel: String,
    questionNumber: Int,
    viewModel: QuestionViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val questionList by viewModel.questions.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val state by viewModel.state.collectAsState()

    var currentIndex by remember { mutableStateOf(0) }
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var showAnswer by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(difficultyLevel, questionNumber) {
        viewModel.loadQuestionsByDifficulty(difficultyLevel, questionNumber)
    }

    if (loading) {
        Text(text = "Loading Questions...", fontSize = 20.sp, modifier = Modifier.padding(16.dp))
        return
    }

    if (questionList.isEmpty()) {
        Text(text = "No questions available.", fontSize = 20.sp, modifier = Modifier.padding(16.dp))
        return
    }

    if (currentIndex >= questionList.size) {
        currentIndex = questionList.size - 1
    }

    val currentQuestion = questionList[currentIndex]
    Scaffold(
        topBar = {

        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .width(120.dp)
                            .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 12.dp, bottomStart = 0.dp, bottomEnd = 12.dp))
                            .background(colorResource(R.color.primary_color).copy(0.8f))
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart,
                    ) {
                        Column {
                            Text("Question", fontSize = 12.sp, color = Color.LightGray)
                            Text("${currentIndex + 1}/${questionList.size}", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }

                    Box(
                        modifier = Modifier
                            .width(120.dp)
                            .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 0.dp, bottomStart = 12.dp, bottomEnd = 0.dp))
                            .background(colorResource(R.color.primary_color).copy(0.8f))
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Column {
                            Text("Level", fontSize = 12.sp, color = Color.LightGray)
                            Text(text = "$difficultyLevel", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.White)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp), clip = true)
                        .shadow(elevation = (-4).dp, shape = RoundedCornerShape(8.dp), clip = true)
                        .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(8.dp))
                        .border(width = 1.dp, color = Color(0xFFDAD4D4), shape = RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = currentQuestion.question,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(28.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(modifier = Modifier.width(120.dp), thickness = 1.dp, color = Color.Black)
                    Text(text = "Options", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                    Divider(modifier = Modifier.width(120.dp), thickness = 1.dp, color = Color.Black)
                }

                Spacer(modifier = modifier.height(22.dp))

                listOf(currentQuestion.optionA, currentQuestion.optionB, currentQuestion.optionC, currentQuestion.optionD).forEach { option ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                selectedOption = option
                                showAnswer = true

                                val isCorrect = option == currentQuestion.correctAnswer
                                viewModel.onEvent(QuestionEvent.AddUserAnswer(currentQuestion, option, isCorrect))

                                coroutineScope.launch {
                                    delay(1000)

                                    if (currentIndex < questionList.size - 1) {
                                        currentIndex++
                                        selectedOption = null
                                        showAnswer = false
                                    } else {
                                        // Calculate score and progress as percentage
                                        val correctAnswers = state.userAnswers.count { it.value.second }
                                        val totalQuestions = questionList.size
                                        val score = (correctAnswers * 100) / totalQuestions
                                        val progress = correctAnswers.toFloat() / questionNumber

                                        // Update score for the specific difficulty
                                        viewModel.onEvent(QuestionEvent.UpdateScore(difficultyLevel, score))

                                        // Update progress for the specific difficulty
                                        viewModel.onEvent(QuestionEvent.UpdateProgress(difficultyLevel, progress))

                                        // Update last attempted timestamp
                                        viewModel.onEvent(QuestionEvent.UpdateLastAttempted(System.currentTimeMillis()))

                                        // Mark quiz as completed
                                        viewModel.onEvent(QuestionEvent.SetQuizCompleted(true))

                                        // Navigate to Result Screen
                                        navController.navigate(Routes.ResultScreen(difficultyLevel)) {
                                            popUpTo(Routes.Quiz) { inclusive = false }
                                        }
                                    }
                                }
                            },
                        elevation = CardDefaults.cardElevation(12.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .height(56.dp)
                                .background(when {
                                    showAnswer && option == currentQuestion.correctAnswer -> Color.Green.copy(0.6f)
                                    showAnswer && option == selectedOption -> Color.Red.copy(0.6f)
                                    else -> Color.White
                                })
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = option, fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}