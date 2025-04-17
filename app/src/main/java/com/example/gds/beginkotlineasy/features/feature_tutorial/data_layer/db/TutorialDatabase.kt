package com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.model.PrepopulateData
import com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.model.TutorialScreenCardDataClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [TutorialScreenCardDataClass::class], version = 1)
@TypeConverters(Converters::class)
abstract class TutorialDatabase : RoomDatabase() {

    abstract fun tutorialCardDao(): TutorialCardDao

    companion object {
        @Volatile
        private var INSTANCE: TutorialDatabase? = null

        fun getDatabase(context: Context): TutorialDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TutorialDatabase::class.java,
                    "tutorial_database"
                )
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Log.d("AppDatabase", "Database created. Checking if data needs to be populated.")

                            CoroutineScope(Dispatchers.IO).launch {
                                val tutorialCardDao = getDatabase(context).tutorialCardDao()

                                // Log the count of tutorial cards
                                val count = tutorialCardDao.getTutorialCardCount()
                                Log.d("AppDatabase", "Tutorial card count: $count")

                                if (count == 0) {
                                    Log.d("AppDatabase", "No data found. Inserting prepopulated data.")
                                    val prepopulatedCards = PrepopulateData.getTutorialCards()
                                    tutorialCardDao.insertAllTutorialCards(prepopulatedCards)
                                    Log.d("AppDatabase", "Prepopulated data inserted successfully.")

                                    // Log the inserted data
                                    val insertedCards = tutorialCardDao.getAllTutorialCardsSync()
                                    Log.d("AppDatabase", "Inserted cards: ${insertedCards.size}")
                                    insertedCards.forEach { card ->
                                        Log.d("AppDatabase", "Card: ${card.cardTitle}, Topics: ${card.topicList.size}")
                                    }
                                } else {
                                    Log.d("AppDatabase", "Data already exists. Skipping insertion.")
                                }
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}