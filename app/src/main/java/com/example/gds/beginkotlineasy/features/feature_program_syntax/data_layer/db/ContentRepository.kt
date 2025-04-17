package com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.db

import com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.model.ContentEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn


/* This file manages data access and provides StateFlow for program and syntax data. */
class ContentRepository(private val contentDao: ContentDao) {

    // Use StateFlow for program and syntax data
    val programData: StateFlow<List<ContentEntity>> = contentDao.getProgramData().stateIn(
        scope = CoroutineScope(Dispatchers.IO),
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val syntaxData: StateFlow<List<ContentEntity>> = contentDao.getSyntaxData().stateIn(
        scope = CoroutineScope(Dispatchers.IO),
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
}