package com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.db
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.model.TutorialScreenCardDataClass
import kotlinx.coroutines.flow.Flow

@Dao
interface TutorialCardDao {

    @Query("SELECT * FROM tutorial_cards")
    fun getAllTutorialCards(): Flow<List<TutorialScreenCardDataClass>>

    /*Added getAllTutorialCardsSync to TutorialCardDao:

This allows synchronous fetching of tutorial cards for logging purposes.*/
    @Query("SELECT * FROM tutorial_cards")
    suspend fun getAllTutorialCardsSync(): List<TutorialScreenCardDataClass>

    @Query("SELECT COUNT(*) FROM tutorial_cards")
    suspend fun getTutorialCardCount(): Int

    @Insert
    suspend fun insertAllTutorialCards(tutorialCards: List<TutorialScreenCardDataClass>)

    @Update
    suspend fun updateTutorialCard(tutorialCard: TutorialScreenCardDataClass)
}