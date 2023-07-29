package com.example.to_docompose.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_docompose.ui.screens.list.listScreen
import com.example.to_docompose.util.Constants

fun NavGraphBuilder.taskComposable(
    navigateToListScreen:(Int)->Unit
){

    composable(
        route = Constants.LIST_SCREEN,
        arguments = listOf(navArgument("task"){
            type= NavType.IntType
        })
    ){
        listScreen(navigateToTaskScreen = navigateToListScreen)
    }
}