package com.example.google_task.database.datastore.repository

import android.icu.util.Calendar
import com.example.google_task.database.dao.TaskDAO
import com.example.google_task.database.entity.TaskCollection
import com.example.google_task.database.entity.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskRepoImpl (
    private val taskDAO: TaskDAO
) : TaskRepo{
    override suspend fun getTaskCollections(): List<TaskCollection>  = withContext(Dispatchers.IO){
        taskDAO.getTaskCollection()
    }

    override suspend fun getTaskCollectionById(id: Int): List<TaskEntity> = withContext(Dispatchers.IO) {
        taskDAO.getTasks(id)
    }

    override suspend fun addTaskCollection(title: String): TaskCollection? {
        val taskCollection = TaskCollection(title = title, updateAt = Calendar.getInstance().timeInMillis)
        val id = taskDAO.insertTaskCollection(taskCollection)
        return if (id > 0) {
            taskCollection.copy(id = taskCollection.id)
        }
        else {
            null
        }
    }
}