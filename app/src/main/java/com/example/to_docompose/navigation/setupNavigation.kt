package com.example.to_docompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.to_docompose.ui.viewModel.viewModel
import com.example.to_docompose.util.Constants.LIST_SCREEN


@Composable
fun setupNavigation(
    navHostController: NavHostController
,viewModel: viewModel
) {

    val sreen = remember(navHostController) {
        screen(navHostController)
    }

    NavHost(
        navController = navHostController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(navigateToTaskScreen = sreen.task,viewModel=viewModel)
        taskComposable(navigateToListScreen = sreen.task,viewModel=viewModel)
    }
}