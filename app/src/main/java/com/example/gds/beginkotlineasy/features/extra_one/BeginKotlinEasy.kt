package com.example.gds.beginkotlineasy.features.extra_one

import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gds.beginkotlineasy.R
import com.example.gds.beginkotlineasy.core.components.HomeContentCard
import com.example.gds.beginkotlineasy.core.components.HomeTutorialProgressCard
import com.example.gds.beginkotlineasy.core.navigation.Routes
import com.example.gds.beginkotlineasy.features.feature_program_syntax.appliction_layer.ContentViewModel
import com.example.gds.beginkotlineasy.features.feature_quiz.appliction_layer.QuestionState
import com.example.gds.beginkotlineasy.features.feature_quiz.appliction_layer.QuestionViewModel
import com.example.gds.beginkotlineasy.features.feature_tutorial.appliction_layer.TutorialViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class ContentCardDataClass(
    val cardTitle: String,
    val contentNumber: String,
    val trailingTitle: String,
    val cardColor: Color,
    val cardRoutes: Routes
)



@Composable
fun BeginKotlinEasy(
    navController: NavController,
    psViewModel: ContentViewModel,
    tutorialViewModel: TutorialViewModel,
    quizViewModel: QuestionViewModel,
) {
    val contentCardList = listOf(
        ContentCardDataClass(
            "Tutorials",
            "104",
            "Topics",
            cardColor = colorResource(R.color.teal_200),
            cardRoutes = Routes.Tutorial
        ),
        ContentCardDataClass(
            "Programs",
            "64",
            "Topics",
            cardColor = colorResource(R.color.primary_color),
            cardRoutes = Routes.ProgramAndSyntax
        ),
        ContentCardDataClass(
            "Syntax",
            "49",
            "Topics",
            cardColor = colorResource(R.color.primary_variant_dark),
            cardRoutes = Routes.Syntax
        ),
        ContentCardDataClass(
            "Interview",
            "42",
            "Topics",
            cardColor = colorResource(R.color.purple_200),
            cardRoutes = Routes.InterviewQuestion
        ),
        ContentCardDataClass(
            "Quiz",
            "58",
            "Topics",
            cardColor = colorResource(R.color.secondary_color),
            cardRoutes = Routes.Quiz
        ),
    )
    // Collect progress state from Tutorial ViewModel
    val tutProgressState = tutorialViewModel.progress.collectAsState()
    // Collect quiz state from Quiz ViewModel
    val quizState = quizViewModel.state.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Tutorial Progress Card
            HomeTutorialProgressCard(
                navController = navController,
                viewModel = tutorialViewModel,
                progress = tutProgressState.value.percentage
            )

            Spacer(modifier = Modifier.height(20.dp))
            // Content section

            Column(
                modifier = Modifier
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Content",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.weight(3f)
                    )
                    Box(
                        modifier = Modifier
                            .weight(8f)
                            .clip(RoundedCornerShape(12.dp))
                    ) {
                        HorizontalDivider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 12.dp),
                            thickness = 2.dp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(14.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                ) {
                    contentCardList.forEach { cardContent ->
                        HomeContentCard(
                            onClick = { navController.navigate(cardContent.cardRoutes) },
                            modifier = Modifier.padding(start = 12.dp, end = 4.dp),
                            cardContent = cardContent
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            // Quiz Progress Card

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Quiz Result",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    modifier = Modifier.weight(5f)
                )
                Box(
                    modifier = Modifier
                        .weight(8f)
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 12.dp),
                        thickness = 2.dp
                    )
                }
            }
            QuizProgressCard(quizState = quizState.value)
        }
    }
}
@Composable
fun QuizProgressCard(
    quizState: QuestionState,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.height(4.dp))
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Top Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Average Score Column
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Average Score",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    val averageScore = listOf(
                        quizState.easyScore.toFloat(),
                        quizState.mediumScore.toFloat(),
                        quizState.hardScore.toFloat()
                    ).average().toFloat()
                    Text(
                        text = "${String.format("%.1f", averageScore)}%",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                }
                // Last Attempted Column
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Last Attempted",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = SimpleDateFormat(
                            "dd MMM yyyy",
                            Locale.getDefault()
                        ).format(Date(quizState.lastAttempted)),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                }
            }

            // Divider
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.1f)
            )

            // Bottom Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Easy Column
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Easy",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (quizState.easyScore > 0) "${quizState.easyScore}%" else "Not Attempted",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                }
                // Medium Column
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Medium",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (quizState.mediumScore > 0) "${quizState.mediumScore}%" else "Not Attempted",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                }
                // Hard Column
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Hard",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (quizState.hardScore > 0) "${quizState.hardScore}%" else "Not Attempted",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                }
            }
        }
    }
}