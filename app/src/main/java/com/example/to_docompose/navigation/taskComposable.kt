package com.example.to_docompose.navigation

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_docompose.ui.screens.list.listScreen
import com.example.to_docompose.ui.screens.task.taskScreen
import com.example.to_docompose.ui.viewModel.viewModell
import com.example.to_docompose.util.Constants
import com.example.to_docompose.util.Constants.TASK_ARGUMENT_KEY
import com.example.to_docompose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (action) -> Unit,
    viewModell: viewModell
) {

    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {navBackStackEntry ->
        val tasskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        Log.e("nav",""+tasskId)
        viewModell.getSelectedTask(tasskId)

        val selectedTask by viewModell._selectedTasks.collectAsState()
        
        LaunchedEffect(key1 = selectedTask){
            viewModell.selectedTask(toDoTask =selectedTask)
        }

        taskScreen(navigationToListScreen = navigateToListScreen,
            selectedTask = selectedTask,viewModell=viewModell)
    }
}