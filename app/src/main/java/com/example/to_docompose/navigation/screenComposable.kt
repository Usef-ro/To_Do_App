package com.example.to_docompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.to_docompose.ui.screens.splashScreen.splashSCreen
import com.example.to_docompose.util.Constants


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.splashScreenComposable(
    navigateToTaskScreen: () -> Unit
) {

    composable(
        route = Constants.SPLASH_SCREEN,
    ) { navigate ->
        splashSCreen(navigateToListScreen = navigateToTaskScreen)
    }

}