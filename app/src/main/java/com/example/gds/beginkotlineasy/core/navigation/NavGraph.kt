package com.example.gds.beginkotlineasy.core.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import com.example.gds.beginkotlineasy.R
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.gds.beginkotlineasy.core.components.PrimaryTopAppBar
import com.example.gds.beginkotlineasy.features.extra_one.BeginKotlinEasy
import com.example.gds.beginkotlineasy.features.extra_one.Setting
import com.example.gds.beginkotlineasy.features.feature_interview_question.presentation.InterviewQuestion
import com.example.gds.beginkotlineasy.features.feature_program_syntax.appliction_layer.ContentViewModel
import com.example.gds.beginkotlineasy.features.feature_program_syntax.presentation.ProgramAndSyntax
import com.example.gds.beginkotlineasy.features.feature_quiz.appliction_layer.QuestionViewModel
import com.example.gds.beginkotlineasy.features.feature_quiz.presentation.Quiz
import com.example.gds.beginkotlineasy.features.feature_quiz.presentation.QuizQuestionScreen
import com.example.gds.beginkotlineasy.features.feature_quiz.presentation.ResultScreen
import com.example.gds.beginkotlineasy.features.feature_tutorial.appliction_layer.TutorialViewModel
import com.example.gds.beginkotlineasy.features.feature_tutorial.presentation.Tutorial
import com.example.gds.beginkotlineasy.features.feature_tutorial.presentation.TutorialDetailsActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(
    programSyntaxViewmodel: ContentViewModel,
    tutorialViewModel: TutorialViewModel,
    quizViewModel: QuestionViewModel,
) {
    val navController = rememberNavController()
    val navItems = listOf(
        navItem(name = "BeginKotlinEasy", icon = painterResource(id =R.drawable.home_icon), route = Routes.BeginKotlinEasy),
        navItem(name = "ProgramAndSyntax", icon = painterResource(id =R.drawable.program_syntax_icon), route = Routes.ProgramAndSyntax),
        navItem(name = "Tutorial", icon = painterResource(id =R.drawable.tutorial_icon), route = Routes.Tutorial),
        navItem(name = "InterviewQuestion", icon = painterResource(id =R.drawable.interview_icon), route = Routes.InterviewQuestion),
        navItem(name = "Quiz", icon = painterResource(id =R.drawable.quiz_icon), route = Routes.Quiz),
    )

    // List of routes that should show bottom navigation
    val bottomNavRoutes = listOf(
        Routes.BeginKotlinEasy::class.qualifiedName,
        Routes.ProgramAndSyntax::class.qualifiedName,
        Routes.Tutorial::class.qualifiedName,
        Routes.InterviewQuestion::class.qualifiedName,
        Routes.Quiz::class.qualifiedName
    )

    // Get current route
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Determine if bottom bar should be visible
    val showBottomBar = bottomNavRoutes.contains(currentRoute)

    Scaffold(

        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    navItems.forEach { item ->
                        NavigationBarItem(
                            icon = { Image(painter = item.icon, contentDescription = item.name, modifier = Modifier.size(28.dp)) },
                            selected = currentRoute == item.route::class.qualifiedName,
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.startDestinationId)
                                    launchSingleTop = true
                                }
                            },
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.BeginKotlinEasy,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White),
        ) {
            // Screens with bottom navigation
            composable<Routes.BeginKotlinEasy> {
                Column(modifier = Modifier.fillMaxSize()) {
                    PrimaryTopAppBar(
                        title = "Begin Kotlin Easy",
                        showBackIcon = false,
                        showActionIcon = true,
                        navController = navController,
                    )
                    BeginKotlinEasy(
                        navController = navController,
                        psViewModel = programSyntaxViewmodel,
                        tutorialViewModel = tutorialViewModel,
                        quizViewModel = quizViewModel
                    )
                }
            }
            composable<Routes.ProgramAndSyntax> {
                Column(modifier = Modifier.fillMaxSize()) {
                    PrimaryTopAppBar(
                        title = "Program and Syntax",
                        showBackIcon = false,
                        showActionIcon = true,
                        navController = navController,
                    )
                ProgramAndSyntax(
                    navController = navController,
                    contentViewModel = programSyntaxViewmodel
                )
                    }
            }
            composable<Routes.Syntax> {
                 Column(modifier = Modifier.fillMaxSize()) {
                     PrimaryTopAppBar(
                         title = "Program and Syntax",
                         showBackIcon = false,
                         showActionIcon = true,
                         navController = navController,
                     )
                     ProgramAndSyntax(
                         navController = navController,
                         contentViewModel = programSyntaxViewmodel,
                         selected = 1
                     )
                 }
            }
            composable<Routes.Tutorial> {
                 Column(modifier = Modifier.fillMaxSize()) {
                     PrimaryTopAppBar(
                         title = "Tutorial",
                         showBackIcon = false,
                         showActionIcon = true,
                         navController = navController,
                     )
                     Tutorial(
                         navController = navController,
                         tutorialViewmodel = tutorialViewModel
                     )
                 }
            }
            composable<Routes.InterviewQuestion> {
                 Column(modifier = Modifier.fillMaxSize()) {
                     PrimaryTopAppBar(
                         title = "Interview Question",
                         showBackIcon = false,
                         showActionIcon = true,
                         navController = navController,
                     )
                     InterviewQuestion(navController = navController)
                 }
            }
            composable<Routes.Quiz> {
                 Column(modifier = Modifier.fillMaxSize()) {
                     PrimaryTopAppBar(
                         title = "Quiz",
                          showBackIcon = false,
                         showActionIcon = true,
                         navController = navController,
                     )
                     Quiz(navController = navController, modifier = Modifier)
                 }
            }

            // Screens without bottom navigation
            composable<Routes.Setting> {
                // You can add a custom top app bar here
                Column(modifier = Modifier.fillMaxSize()) {
                    PrimaryTopAppBar(
                        title = "Setting",
                        showBackIcon = true,
                        showActionIcon = false,
                        navController = navController,
                    )
                    Setting(navController = navController)
                }
            }
            composable<Routes.TutorialDetailsActivity> { backStackEntry ->
                val title = backStackEntry.toRoute<Routes.TutorialDetailsActivity>().title
                Column(modifier = Modifier.fillMaxSize()) {

                    TutorialDetailsActivity(
                        navController = navController,
                        viewModel = tutorialViewModel,
                        title = title
                    )
                }
            }
            composable<Routes.QuizQuestionScreen> { backStackEntry ->
                val data = backStackEntry.toRoute<Routes.QuizQuestionScreen>()
                Column(modifier = Modifier.fillMaxSize()) {
                    PrimaryTopAppBar(
                        title = "Quiz Question Screen",
                        showBackIcon = true,
                        showActionIcon = false,
                        navController = navController,
                    )
                    QuizQuestionScreen(
                        difficultyLevel = data.difficultyLevel,
                        questionNumber = data.questionNumber,
                        viewModel = quizViewModel,
                        navController = navController
                    )
                }
            }
            composable<Routes.ResultScreen> { backStackEntry ->
                val data = backStackEntry.toRoute<Routes.ResultScreen>()
                Column(modifier = Modifier.fillMaxSize()) {
                    PrimaryTopAppBar(
                        title = "Result Screen",
                        showBackIcon = true,
                        showActionIcon = false,
                        navController = navController,
                    )
                    ResultScreen(
                        viewModel = quizViewModel,
                        navController = navController,
                        difficultyLevel = data.difficultyLevel
                    )
                }
            }
        }
    }
}
data class navItem(val name: String, val icon: Painter, val route: Routes)