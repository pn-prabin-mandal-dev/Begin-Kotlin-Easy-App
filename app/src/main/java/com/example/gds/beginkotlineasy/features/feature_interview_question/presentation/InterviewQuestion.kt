package com.example.gds.beginkotlineasy.features.feature_interview_question.presentation

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.gds.beginkotlineasy.features.feature_interview_question.appliction_layer.InterviewQuestionViewModel
import com.example.gds.beginkotlineasy.features.feature_interview_question.data_layer.data.InterviewQuestion

@Composable
fun InterviewQuestion(
    viewModel: InterviewQuestionViewModel = viewModel(), // as we already defined default we not need to pass in navGraph
    navController: NavController, // kept here for future use
    modifier: Modifier = Modifier,
)  {

    val questions by viewModel.questions.collectAsState()
    // The questions state is observed using collectAsState(),
    // ensuring the UI updates whenever the data changes.

    LazyColumn(
        modifier = modifier.background(color = Color.Transparent),
    ) {
        items(questions) { question ->
            QuestionItem(question = question)
        }
    }
}

@Composable
fun QuestionItem(question: InterviewQuestion) {
    var expanded by remember { mutableStateOf(false) }
    val contentAlpha = if (expanded) 1f else 0.5f
    val rotationState by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f
    )

    Card(
        modifier = Modifier
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300, // not delayMillis
                    easing = LinearOutSlowInEasing
                )
            )
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.Transparent),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),

        onClick = {
            expanded = !expanded
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primaryContainer.copy(0.6f))
        ){
            Column(
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 4.dp)
                    .background(Color.Transparent)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = question.question,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.weight(6f),
                        maxLines = 2,
                        color = Color.Black.copy(0.9f)
                    )

                    IconButton(
                        modifier = Modifier
                            .weight(1f)
                            .alpha(contentAlpha)
                            .rotate(rotationState),
                        onClick = {
                            expanded = !expanded
                        }
                    ) {
                        Icon(
                            Icons.Default.KeyboardArrowDown,
                            contentDescription = "Drop Down Arrow"
                        )
                    }
                }

            }
        }
        // content
        // Display content when expanded
        if (expanded) {
            // Wrap the Text with a Box to make sure it gets proper scrollable constraints
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp, bottomStart = 8.dp, bottomEnd = 8.dp))
                    .background(Color.White)
            ) {
                Text(
                    text = question.answer,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                    ),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    maxLines = Int.MAX_VALUE, // Removes the maxLines limit when expanded
                    overflow = TextOverflow.Clip // Avoid text truncation in expanded state
                )
            }
        }

    }
}