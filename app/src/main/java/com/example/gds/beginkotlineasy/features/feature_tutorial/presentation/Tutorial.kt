package com.example.gds.beginkotlineasy.features.feature_tutorial.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import com.example.gds.beginkotlineasy.R
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gds.beginkotlineasy.core.components.GradientButtonWithText
import com.example.gds.beginkotlineasy.core.navigation.Routes
import com.example.gds.beginkotlineasy.features.feature_tutorial.appliction_layer.Tutorial
import com.example.gds.beginkotlineasy.features.feature_tutorial.appliction_layer.TutorialViewModel
import kotlin.compareTo
import kotlin.text.toInt
import kotlin.times

@Composable
fun Tutorial(
    navController: NavController,
    tutorialViewmodel: TutorialViewModel,
) {
    // Collect tutorials state from ViewModel
    val tutorialsState = tutorialViewmodel.tutorials.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(tutorialsState.value) {tutorial->
                TutorialCard(
                    tutorial = tutorial,
                    onStartCourseClick = {
                        navController.navigate(Routes.TutorialDetailsActivity(tutorial.title))
                    },
                    onRestartClick = {
                        tutorialViewmodel.resetCurrentTopicIndex(tutorial.id)
                        navController.navigate(Routes.TutorialDetailsActivity(tutorial.title))
                    },
                    onResumeClick = {
                        navController.navigate(Routes.TutorialDetailsActivity(tutorial.title))
                    },
                    // Show only Restart if progress is 100%
                    showRestartOnly = tutorial.progress >= 1.0f
                )
            }
        }
    }
}

@Composable
fun TutorialCard(
    tutorial: Tutorial,
    onStartCourseClick: () -> Unit,
    onRestartClick: () -> Unit,
    showRestartOnly: Boolean = false, // New parameter
    onResumeClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight().padding(top = 12.dp, bottom = 8.dp, start = 12.dp, end = 12.dp),
        shape = RoundedCornerShape(
            topStart = 8.dp,
            topEnd = 60.dp,
            bottomStart = 8.dp,
            bottomEnd = 8.dp
        ),
        colors = CardDefaults.cardColors().copy(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 12.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            // row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // content
                Column(
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth()
                        .weight(5f)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(
                        text = tutorial.title,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = MaterialTheme.colorScheme.primary
                        ),
                    )
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ){
                        VerticalDivider(modifier = Modifier.height(180.dp), thickness = 3.dp)
                        Column(
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState()),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "Topic Available",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.Black.copy(0.8f)
                                )
                            )
                            /*tutorial.topics.forEach { topic ->
                                if (!tutorial.remainingTopics.contains(topic.title)) {
                                    Text(
                                        text = "- ${topic.title}",
                                        fontSize = 14.sp,
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                }
                            }*/
                            tutorial.topics.forEach { topic ->
                                Row(
                                    verticalAlignment = Alignment.Bottom,
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    Icon(Icons.Default.PlayArrow, contentDescription = "InComplete Icon", tint =Color(0xFFF86132).copy(0.8f), modifier = Modifier.size(22.dp))
                                    Text(
                                        text = topic.title,
                                        style = TextStyle(
                                            fontWeight = FontWeight.Normal,
                                            fontSize = 16.sp,
                                            color = Color.Black.copy(0.6f),
                                        ),
                                        modifier = Modifier.width(120.dp),
                                        maxLines = 1,
                                    )
                                }
                            }
                        }
                    }
                }


                Box(
                    modifier = Modifier.padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // Background track
                    CircularProgressIndicator(
                        progress = 1f,
                        strokeCap = StrokeCap.Round,
                        strokeWidth = 4.dp,
                        modifier = Modifier.size(100.dp),
                        color = Color.LightGray.copy(alpha = 0.3f) // You can customize this
                    )

                    // Foreground progress
                    CircularProgressIndicator(
                        progress = tutorial.progress,
                        strokeCap = StrokeCap.Round,
                        strokeWidth = 4.dp,
                        modifier = Modifier.size(100.dp),
                        color = MaterialTheme.colorScheme.primary.copy(0.8f)
                    )

                    // Centered Text
                    Column(
                        verticalArrangement = Arrangement.spacedBy(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "${(tutorial.progress * 100).toInt()}%",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 20.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                        Text(
                            text = "Progress",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black.copy(0.4f)
                            )
                        )
                    }
                }
            }


            // button
            if (tutorial.progress > 0) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    GradientButtonWithText(
                        onClick = onRestartClick,
                        modifier = Modifier.weight(1f),
                        text = "Restart"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    GradientButtonWithText(
                        onClick = onResumeClick,
                        modifier = Modifier.weight(1f),
                        text = "Resume"
                    )
                }
            } else {
                GradientButtonWithText(
                    onClick = onStartCourseClick,
                    modifier = Modifier.fillMaxWidth(),
                    text = "Start Course"
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PrimaryButton(
    onClick: () -> Unit = {},
    text: String = "Primary Button",
    modifier: Modifier = Modifier,
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val primaryTransparent = primaryColor.copy(alpha = 0.5f)

    Box(
        modifier = modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        primaryColor,
                        primaryTransparent
                    )
                ),
                shape = RoundedCornerShape(12.dp), // Optional: Adds rounded corner
            ),
    ) {
        Button(
            onClick = onClick,
            modifier = modifier.fillMaxWidth(),
            elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Make Button itself transparent
        ) {
            Text(text = text, color = MaterialTheme.colorScheme.onPrimary)
        }
    }
}