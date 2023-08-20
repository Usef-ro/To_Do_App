package com.example.to_docompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.to_docompose.ui.viewModel.viewModell
import com.example.to_docompose.util.Constants.LIST_SCREEN
import com.example.to_docompose.util.Constants.SPLASH_SCREEN
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun setupNavigation(
    navHostController: NavHostController, viewModell: viewModell
) {

    val sreen = remember(navHostController) {
        screen(navHostController)
    }

    AnimatedNavHost(
        navController = navHostController,
        startDestination = SPLASH_SCREEN
    ) {
        splashScreenComposable(
            navigateToTaskScreen = sreen.splash
        )
        listComposable(
            navigateToTaskScreen = sreen.task, viewModell = viewModell
        )
        taskComposable(
            navigateToListScreen = sreen.list, viewModell = viewModell
        )
    }

}