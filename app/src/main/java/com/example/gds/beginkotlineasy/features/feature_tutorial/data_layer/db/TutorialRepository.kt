package com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.db
import android.util.Log
import com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.model.TutorialScreenCardDataClass
import kotlinx.coroutines.flow.Flow

class TutorialRepository(private val tutorialCardDao: TutorialCardDao) {

    // Fetch all tutorial cards as a Flow
    fun getAllTutorialCards(): Flow<List<TutorialScreenCardDataClass>> {
        Log.d("TutorialRepository", "Fetching all tutorial cards from the database.")
        return tutorialCardDao.getAllTutorialCards()
    }

    suspend fun updateTutorialCard(tutorialCard: TutorialScreenCardDataClass) {
        Log.d("TutorialRepository", "Updating tutorial card: ${tutorialCard.cardTitle}")
        Log.d("TutorialRepository", "Updated topic completion: ${tutorialCard.topicCompletion}")
        tutorialCardDao.updateTutorialCard(tutorialCard)
    }
}