package com.example.to_docompose.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_docompose.ui.screens.list.listScreen
import com.example.to_docompose.ui.viewModel.viewModel
import com.example.to_docompose.util.Constants


fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (Int) -> Unit,
    viewModel: viewModel
) {

    composable(
        route = Constants.LIST_SCREEN,
        arguments = listOf(navArgument("action") {
            type = NavType.StringType
        })
    ) {
        listScreen(navigateToTaskScreen = navigateToTaskScreen,viewModel=viewModel)
    }
}