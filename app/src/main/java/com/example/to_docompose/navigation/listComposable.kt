package com.example.to_docompose.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_docompose.util.Constants


fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (Int) -> Unit
) {

    composable(
        route = Constants.LIST_SCREEN,
        arguments = listOf(navArgument("action") {
            type = NavType.StringType
        })
    ) {

    }
}