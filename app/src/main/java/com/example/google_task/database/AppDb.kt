package com.example.google_task.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.google_task.database.dao.TaskDAO
import com.example.google_task.database.entity.TaskCollection
import com.example.google_task.database.entity.TaskEntity

private const val DATABASE_NAME = "app.db"
private const val DATABASE_VERSION = 1
@Database(
    entities = [TaskCollection::class, TaskEntity::class],
    version = DATABASE_VERSION
)
abstract class AppDb : RoomDatabase() {
    abstract fun taskDAO() : TaskDAO
//    Singleton Pattern
    companion object {
        private var instance: AppDb? = null
        operator fun invoke (context: Context) :AppDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase (context: Context) : AppDb = Room.databaseBuilder( //    Room.databaseBuilder() để tạo database thực sự với tên file app.db.
            context.applicationContext,
            AppDb::class.java,
            DATABASE_NAME
        ).build()

    }
}