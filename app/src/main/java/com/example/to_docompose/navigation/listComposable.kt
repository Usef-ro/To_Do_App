package com.example.to_docompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_docompose.ui.screens.list.listScreen
import com.example.to_docompose.ui.viewModel.viewModell
import com.example.to_docompose.util.Constants
import com.example.to_docompose.util.Constants.LIST_ARGUMENT_KEY
import com.google.accompanist.navigation.animation.composable


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    viewModell: viewModell
) {

    composable(
        route = Constants.LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) { navigate ->
        val action = navigate.arguments?.getString(LIST_ARGUMENT_KEY).action()

        LaunchedEffect(key1 = action) {
            viewModell.action.value = action
        }

        listScreen(navigateToTaskScreen = navigateToTaskScreen, viewModell = viewModell)
    }
}