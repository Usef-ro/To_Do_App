package com.example.to_docompose.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_docompose.ui.screens.list.listScreen
import com.example.to_docompose.ui.viewModel.viewModell
import com.example.to_docompose.util.Constants


fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId:Int) -> Unit
    ,
    viewModell: viewModell
) {

    composable(
        route = Constants.LIST_SCREEN,
        arguments = listOf(navArgument("action") {
            type = NavType.StringType
        })
    ) {
        listScreen(navigateToTaskScreen = navigateToTaskScreen,viewModell=viewModell)
    }
}