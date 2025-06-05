package com.example.google_task

import androidx.lifecycle.ViewModel
import com.example.google_task.repository.TaskRepo
import javax.inject.Inject

class MainViewModel
    @Inject constructor(
    private val taskRepo : TaskRepo
    ) : ViewModel() {

    }