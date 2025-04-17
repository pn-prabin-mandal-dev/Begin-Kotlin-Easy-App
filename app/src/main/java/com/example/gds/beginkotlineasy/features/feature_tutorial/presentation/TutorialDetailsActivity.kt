package com.example.gds.beginkotlineasy.features.feature_tutorial.presentation

import android.util.Log
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gds.beginkotlineasy.core.components.GradientButtonWithText
import com.example.gds.beginkotlineasy.core.components.PrimaryTopAppBar
import com.example.gds.beginkotlineasy.features.feature_tutorial.appliction_layer.TutorialProgressEvent
import com.example.gds.beginkotlineasy.features.feature_tutorial.appliction_layer.TutorialViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TutorialDetailsActivity(
    navController: NavController,
    viewModel: TutorialViewModel,
    title: String,
    modifier: Modifier = Modifier
) {
    // Set the current tutorial title
    LaunchedEffect(title) {
        viewModel.setCurrentTutorialTitle(title)
    }

    // Collect the current tutorial from ViewModel
    val tutorial = viewModel.getTutorial(title)
    val currentTopicIndex = viewModel.getCurrentTopicIndexFlow(tutorial.id).collectAsState()

    // Log the current tutorial and index
    LaunchedEffect(tutorial, currentTopicIndex.value) {
        Log.d("DetailScreen", "Current Tutorial: ${tutorial.title}, Current Index: ${currentTopicIndex.value}")
    }

    // Get the current topic
    val currentTopic = if (currentTopicIndex.value < tutorial.topics.size) {
        tutorial.topics[currentTopicIndex.value]
    } else {
        // Fallback to the first topic if the index is out of bounds
        Log.d("DetailScreen", "Index out of bounds, falling back to first topic")
        tutorial.topics[0]
    }

    // Mark the current topic as completed when the user navigates to it
    LaunchedEffect(currentTopic) {
        Log.d("DetailScreen", "Marking topic as completed: ${currentTopic.title}")
        viewModel.onEvent(
            TutorialProgressEvent.MarkTopicCompleted(
                cardId = tutorial.id,
                topic = currentTopic.title
            )
        )
    }

    Scaffold(
        topBar = {
            PrimaryTopAppBar(
                title = tutorial.title,
                showBackIcon = true,
                navController = navController,
                showActionIcon = true
            )
        },

        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp) // Fixed height
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    // Single button case (first or last topic)
                    if (currentTopicIndex.value == 0 || currentTopicIndex.value == tutorial.topics.size - 1) {
                        GradientButtonWithText(
                            text = if (currentTopicIndex.value < tutorial.topics.size - 1) "Next" else "Finish",
                            onClick = {
                                if (currentTopicIndex.value < tutorial.topics.size - 1) {
                                    viewModel.setCurrentTopicIndex(tutorial.id, currentTopicIndex.value + 1)
                                } else {
                                    navController.navigateUp()
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp) // Fixed button height
                        )
                    }
                    // Two buttons case (middle topics)
                    else {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            GradientButtonWithText(
                                text = "Previous",
                                onClick = {
                                    viewModel.setCurrentTopicIndex(tutorial.id, currentTopicIndex.value - 1)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .height(48.dp) // Fixed button height
                            )

                            Spacer(modifier = Modifier.width(16.dp))

                            GradientButtonWithText(
                                text = "Next",
                                onClick = {
                                    viewModel.setCurrentTopicIndex(tutorial.id, currentTopicIndex.value + 1)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .height(48.dp) // Fixed button height  // important for not movement of button slightly up
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Card for current topic title
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.elevatedCardElevation(12.dp)
            ) {
                Text(
                    text = currentTopic.title,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

            // Card(s) for current topic content
            currentTopic.content.split("\n").forEach { content ->
                Card(
                    modifier = Modifier.fillMaxWidth().wrapContentHeight()
                ) {
                    Text(
                        text = content,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}