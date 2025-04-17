package com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.db
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.model.ContentEntity
import kotlinx.coroutines.flow.Flow

/* This file defines the database operations. */
@Dao
interface ContentDao {

    // Insert content into the database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(content: List<ContentEntity>)

    // Get all content from the database
    @Query("SELECT * FROM content")
    fun getAllContent(): Flow<List<ContentEntity>>

    // Get content filtered by type (e.g., "Program" or "Syntax")
    @Query("SELECT * FROM content WHERE type = :type")
    fun getContentByType(type: String): Flow<List<ContentEntity>>

    // Get program data (content where type = "Program")
    fun getProgramData(): Flow<List<ContentEntity>> = getContentByType("Program")

    // Get syntax data (content where type = "Syntax")
    fun getSyntaxData(): Flow<List<ContentEntity>> = getContentByType("Syntax")

    // Get a single content item by ID (useful for detailed views)
    @Query("SELECT * FROM content WHERE id = :id")
    fun getContentById(id: Int): Flow<ContentEntity?>

    // Delete all content (useful for testing or resetting the database)
    @Query("DELETE FROM content")
    suspend fun deleteAll()
}