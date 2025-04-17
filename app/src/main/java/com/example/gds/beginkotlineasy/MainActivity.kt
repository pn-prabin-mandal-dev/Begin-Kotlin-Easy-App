package com.example.gds.beginkotlineasy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gds.beginkotlineasy.core.navigation.NavGraph
import com.example.gds.beginkotlineasy.features.feature_program_syntax.appliction_layer.ContentViewModel
import com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.db.ContentDatabase
import com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.db.ContentRepository
import com.example.gds.beginkotlineasy.features.feature_quiz.appliction_layer.QuestionViewModel
import com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.db.QuestionDatabase
import com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.db.QuestionRepository
import com.example.gds.beginkotlineasy.features.feature_tutorial.appliction_layer.TutorialViewModel
import com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.db.TutorialDatabase
import com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.db.TutorialRepository
import com.example.gds.beginkotlineasy.ui.theme.BeginKotlinEasyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // program and syntax
        val psDatabase = ContentDatabase.getDatabase(applicationContext)
        val psRepository = ContentRepository(psDatabase.contentDao())
        val psViewModel = ContentViewModel(repository = psRepository, application = application)

        // tutorial
        // Initialize the database and repository
        val database = TutorialDatabase.getDatabase(this)
        val repository = TutorialRepository(database.tutorialCardDao())
        // Initialize the ViewModel
        val viewModel = TutorialViewModel(repository = repository)

        // Quiz
        val quizDao: QuestionDatabase = QuestionDatabase.getDatabase(applicationContext) // Gets the database instance
        val quizRepo: QuestionRepository = QuestionRepository(quizDao.questionDao()) // Creates the repository
        val quizViewModel = QuestionViewModel(repository = quizRepo, application = application) // Creates the ViewModel

        setContent {
            BeginKotlinEasyTheme {
                // Set up the navigation graph
                NavGraph(programSyntaxViewmodel = psViewModel,tutorialViewModel = viewModel, quizViewModel = quizViewModel)
            }
        }
    }
}

