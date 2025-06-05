package com.example.google_task.di

import com.example.google_task.database.dao.TaskDAO
import com.example.google_task.repository.TaskRepo
import com.example.google_task.repository.TaskRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton // tao ra duy nhat 1 thuc the

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Singleton
    @Provides
    fun  providesTaskRepo(taskDAO: TaskDAO) : TaskRepo {
        return TaskRepoImpl(taskDAO)
    }
}