package com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.model.ContentEntity
import com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.model.ProgramData
import com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.model.SyntaxData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/* Use the SharedPreferences flag to clear the database and insert new data on the first launch:
* This file ensures the database is cleared and reinitialized on the first launch.
*/
@Database(entities = [ContentEntity::class], version = 1, exportSchema = false)
abstract class ContentDatabase : RoomDatabase() {
    abstract fun contentDao(): ContentDao

    companion object {
        @Volatile
        private var INSTANCE: ContentDatabase? = null

        fun getDatabase(context: Context): ContentDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContentDatabase::class.java,
                    "content_database"
                ).addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        CoroutineScope(Dispatchers.IO).launch {
                            Log.d("AppDatabase", "Inserting initial data...")
                            INSTANCE?.contentDao()?.insertAll(ProgramData.topics + SyntaxData.topics)
                            Log.d("AppDatabase", "Initial data inserted.")
                        }
                    }

                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                        CoroutineScope(Dispatchers.IO).launch {
                            val contentDao = INSTANCE?.contentDao()
                            if (contentDao != null) {
                                val appPreferences = AppPreferences(context.applicationContext)
                                if (appPreferences.isFirstLaunch()) {
                                    // Clear the database
                                    contentDao.deleteAll()
                                    Log.d("AppDatabase", "Database cleared.")

                                    // Insert the new data
                                    Log.d("AppDatabase", "Inserting initial data...")
                                    contentDao.insertAll(ProgramData.topics + SyntaxData.topics)
                                    Log.d("AppDatabase", "Initial data inserted.")

                                    // Mark first launch as complete
                                    appPreferences.setFirstLaunch(false)
                                }
                            }
                        }
                    }
                }).build()
                INSTANCE = instance
                instance
            }
        }
    }
}