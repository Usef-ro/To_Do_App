package com.example.to_docompose.ui.screens.task

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.to_docompose.components.priorityItemScreen
import com.example.to_docompose.data.domain.model.Priority
import com.example.to_docompose.data.domain.model.ToDoTask
import com.example.to_docompose.navigation.action

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun taskScreen(navigationToListScreen:(action)->Unit,selectedTask :ToDoTask?){

    Scaffold(
        topBar = {
            taskAppBar(navigationToListScreen = navigationToListScreen,selectedTask =selectedTask )
        },
        content = {
            priorityItemScreen(priority = Priority.LOW, onPrioritySelected ={},padding=it )
        }
    )

}
