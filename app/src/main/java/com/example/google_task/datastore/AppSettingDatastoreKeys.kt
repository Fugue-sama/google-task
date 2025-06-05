package com.example.google_task.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey

object AppSettingDatastoreKeys {
    val IS_NOTIFICATION_ON = booleanPreferencesKey("is_notification_on")
}