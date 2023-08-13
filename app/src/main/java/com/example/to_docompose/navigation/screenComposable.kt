package com.example.to_docompose.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_docompose.ui.screens.list.listScreen
import com.example.to_docompose.ui.screens.splashScreen.splashSCreen
import com.example.to_docompose.ui.viewModel.viewModell
import com.example.to_docompose.util.Constants
import com.example.to_docompose.util.Constants.LIST_ARGUMENT_KEY


fun NavGraphBuilder.splashScreenComposable(
    navigateToTaskScreen: () -> Unit
) {

    composable(
        route = Constants.SPLASH_SCREEN,

    ) { navigate ->
        splashSCreen(navigateToListScreen=navigateToTaskScreen)
    }
}