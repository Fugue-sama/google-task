package com.example.google_task.database.datastore

import kotlinx.coroutines.flow.Flow

interface AppSetting {
    val appSettingFlow: Flow<AppSettingData>

    suspend fun setIsNotificationOn(isNotificationOn: Boolean)
    suspend fun getIsNotificationOn() : Boolean
}