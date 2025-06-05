package com.example.google_task.di

import android.content.Context
import com.example.google_task.database.AppDb
import com.example.google_task.database.dao.TaskDAO
import com.example.google_task.repository.TaskRepo
import com.example.google_task.repository.TaskRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
// cung cap object can thiet
object DatabaseModule {

    @Provides
    fun provideTaskDao(appDb: AppDb) : TaskDAO {
        return appDb.taskDAO()
    }

    @Provides
    fun  provideAppDb(@ApplicationContext context: Context) : AppDb {
        return AppDb.invoke(context)
    }


}