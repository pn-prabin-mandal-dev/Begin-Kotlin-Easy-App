package com.example.gds.beginkotlineasy.features.feature_quiz.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gds.beginkotlineasy.core.components.PrimaryTopAppBar
import com.example.gds.beginkotlineasy.features.feature_quiz.appliction_layer.QuestionViewModel

@Composable
fun ResultScreen(
    viewModel: QuestionViewModel,
    navController: NavController,
    difficultyLevel: String,
    modifier: Modifier = Modifier
) {
    val state = viewModel.state.collectAsState()

    BackHandler {
        navController.popBackStack()
    }

    Scaffold(
        topBar = {
            /*PrimaryTopAppBar(
                title = "Quiz Result",
                *//*showBackIcon = true,
                showActionIcon = false,*//*
                onBackClick = { navController.popBackStack() },
                navController = navController
            )*/
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier.padding(innerPadding)
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Quiz Results",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Card {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val correctAnswers = state.value.userAnswers.count { it.value.second }
                        val wrongAnswers = state.value.userAnswers.size - correctAnswers

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "Correct Answers",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "$correctAnswers",
                                    fontSize = 24.sp,
                                    color = Color.Green.copy(0.8f)
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "Wrong Answers",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "$wrongAnswers",
                                    fontSize = 24.sp,
                                    color = Color.Red
                                )
                            }
                        }

                        // Display Progress for the Selected Difficulty Level in Percentage
                        val progress = when (difficultyLevel) {
                            "Easy" -> state.value.easyProgress
                            "Medium" -> state.value.mediumProgress
                            "Hard" -> state.value.hardProgress
                            else -> 0f
                        }

                        Text(
                            text = "$difficultyLevel",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "Progress: ${(progress * 100).toInt()}%",
                            fontSize = 20.sp,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Correct Answers:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                val correctAnswerList = state.value.userAnswers.filter { it.value.second }
                if (correctAnswerList.isEmpty()) {
                    Text(text = "No correct answers!", fontSize = 16.sp, color = Color.Green)
                } else {
                    correctAnswerList.forEach { (question, answer) ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(text = "Question: ${question.question}", fontSize = 16.sp)
                            listOf(
                                question.optionA,
                                question.optionB,
                                question.optionC,
                                question.optionD
                            ).forEach { option ->
                                Text(
                                    text = option,
                                    fontSize = 16.sp,
                                    color = if (option == question.correctAnswer) Color.Green else Color.Black
                                )
                            }
                            Divider(modifier = Modifier.padding(vertical = 8.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Wrong Answers:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                val wrongAnswerList = state.value.userAnswers.filter { !it.value.second }
                if (wrongAnswerList.isEmpty()) {
                    Text(text = "No wrong answers!", fontSize = 16.sp, color = Color.Green)
                } else {
                    wrongAnswerList.forEach { (question, answer) ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(text = "Question: ${question.question}", fontSize = 16.sp)
                            listOf(
                                question.optionA,
                                question.optionB,
                                question.optionC,
                                question.optionD
                            ).forEach { option ->
                                Text(
                                    text = option,
                                    fontSize = 16.sp,
                                    color = when {
                                        option == question.correctAnswer -> Color.Green
                                        option == answer.first -> Color.Red
                                        else -> Color.Black
                                    }
                                )
                            }
                            Divider(modifier = Modifier.padding(vertical = 8.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}