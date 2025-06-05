package com.example.google_task.repository

import com.example.google_task.database.entity.TaskCollection
import com.example.google_task.database.entity.TaskEntity

interface TaskRepo {
    suspend fun getTaskCollections (): List<TaskCollection>
    suspend fun getTaskCollectionById (id: Int) :  List<TaskEntity>
    suspend fun addTaskCollection (title: String) : TaskCollection?

}