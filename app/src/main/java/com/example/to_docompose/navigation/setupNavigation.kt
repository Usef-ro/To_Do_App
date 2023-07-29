package com.example.to_docompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_docompose.util.Constants.LIST_SCREEN


@Composable
fun setupNavigation(navHostController: NavHostController) {

    val sreen= remember(navHostController) {
        screen(navHostController)
    }

    NavHost(
        navController=navHostController,
        startDestination = LIST_SCREEN
    ){
listComposable(navigateToTaskScreen = sreen.task)
        taskComposable(navigateToListScreen = sreen.task)
    }
}