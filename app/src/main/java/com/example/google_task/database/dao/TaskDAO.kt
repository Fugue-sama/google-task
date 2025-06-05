package com.example.google_task.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.google_task.database.entity.TaskCollection
import com.example.google_task.database.entity.TaskEntity

@Dao
interface TaskDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskCollection(taskCollection: TaskCollection) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity) : Long

    @Query("SELECT * FROM task_collection")
    suspend fun getTaskCollection(): List<TaskCollection>

    @Query("SELECT * FROM task WHERE collection_id = :collectionId")
    suspend fun getTasks(collectionId: Int): List<TaskEntity>

    @Query ("UPDATE task SET is_favorite = :isFavorite WHERE id = :taskId")
    suspend fun updateTaskFavorite(taskId: Int, isFavorite: Boolean)

    @Query ("UPDATE task SET is_completed = :isCompleted WHERE id = :taskId")
    suspend fun updateTaskCompleted(taskId: Int, isCompleted: Boolean)

    @Query("UPDATE task_collection SET title = :title WHERE id = :collectionId")
    suspend fun updateTaskCollectionTitle(collectionId: Int, title: String)

    @Update
    suspend fun updateTaskCollection(taskCollection: TaskCollection)
    @Update
    suspend fun updateTask(task: TaskEntity)

    @Delete
    suspend fun deleteTaskCollection(taskCollection: TaskCollection)
    @Delete
    suspend fun deleteTask(task: TaskEntity)

}