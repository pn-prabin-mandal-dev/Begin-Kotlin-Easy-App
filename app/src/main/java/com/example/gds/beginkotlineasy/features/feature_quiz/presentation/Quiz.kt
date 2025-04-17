package com.example.gds.beginkotlineasy.features.feature_quiz.presentation

import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gds.beginkotlineasy.core.components.GradientButtonWithText
import com.example.gds.beginkotlineasy.core.navigation.Routes
import com.example.gds.beginkotlineasy.features.feature_tutorial.presentation.PrimaryButton

private val gradientOnClick = Brush.horizontalGradient(
    colors = listOf(Color(0xff1D116D), Color(0xff8E93F0)) // Gradient for selected buttons
)

@Composable
fun Quiz(navController: NavController,modifier: Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var selectedLevel by remember { mutableStateOf<String?>(null) } // Tracks selected difficulty level
        var selectedQuestions by remember { mutableStateOf<Int?>(null) } // Tracks selected question count
        val context = LocalContext.current // Context for showing Toasts

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 24.dp, end = 16.dp, bottom = 16.dp)
        ) {
            QuizContent("Difficulty Level") // Displays the difficulty level section
            Spacer(modifier = Modifier.height(12.dp))

            // Allows users to select a difficulty level
            LevelButton(
                selectedLevel = selectedLevel,
                onLevelSelected = { selectedLevel = it }
            )

            Spacer(modifier = Modifier.height(20.dp))
            QuizContent("Number of Questions") // Displays the question count section

            // Allows users to select the number of questions
            QuestionOption(
                selectedQuestions = selectedQuestions,
                onQuestionsSelected = { selectedQuestions = it }
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Button to start the quiz based on selected options
            GradientButtonWithText(
                text = "Start Quiz",
                onClick = {when {
                    selectedLevel == null -> {
                        Toast.makeText(context, "Please select a difficulty level.", Toast.LENGTH_SHORT).show()
                    }
                    selectedQuestions == null -> {
                        Toast.makeText(context, "Please select the number of questions.", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        Toast.makeText(context, "Starting quiz with $selectedLevel level and $selectedQuestions questions.", Toast.LENGTH_SHORT).show()
                        navController.navigate(Routes.QuizQuestionScreen(selectedLevel!!, selectedQuestions!!))
                    }
                }},
                // Note: not inside modifier as you already called on onClick in Btn
                /*modifier = Modifier.clickable {

                }*/
            )
        }
    }
}


@Composable
fun LevelButton(
    selectedLevel: String?, // Tracks the selected difficulty level
    onLevelSelected: (String) -> Unit // Callback for level selection
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        listOf("Easy", "Medium", "Hard").forEach { level ->
            LevelOption(
                level = level,
                isSelected = selectedLevel == level,
                onSelect = { onLevelSelected(level) }
            )
        }
    }
}

@Composable
fun LevelOption(level: String, isSelected: Boolean, onSelect: () -> Unit) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onSelect()
                Toast.makeText(context, "$level selected", Toast.LENGTH_SHORT).show()
            },
        elevation = CardDefaults.cardElevation(16.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            modifier = Modifier
                .height(56.dp)
                .background(if (isSelected) gradientOnClick else SolidColor(Color.White))
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = level,
                color = if (isSelected) Color.White else Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun QuestionOption(selectedQuestions: Int?, onQuestionsSelected: (Int) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOf(10, 15, 25).forEach { number ->
                QuestionItem(
                    number = number,
                    isSelected = selectedQuestions == number,
                    onSelect = { onQuestionsSelected(number) }
                )
            }
        }
    }
}

@Composable
fun QuestionItem(number: Int, isSelected: Boolean, onSelect: () -> Unit) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onSelect()
                Toast.makeText(context, "$number selected", Toast.LENGTH_SHORT).show()
            },
        elevation = CardDefaults.cardElevation(16.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Box(
            modifier = Modifier
                .background(if (isSelected) gradientOnClick else SolidColor(Color.White))
                .padding(vertical = 16.dp, horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$number",
                color = if (isSelected) Color.White else Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun QuizContent(name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )

        Text(
            text = name,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )

        Divider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
        )
    }
}