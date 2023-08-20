package com.example.to_docompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navArgument
import com.example.to_docompose.ui.screens.list.listScreen
import com.example.to_docompose.ui.screens.splashScreen.splashSCreen
import com.example.to_docompose.ui.viewModel.viewModell
import com.example.to_docompose.util.Constants
import com.example.to_docompose.util.Constants.LIST_ARGUMENT_KEY
import kotlin.system.exitProcess


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.splashScreenComposable(
    navigateToTaskScreen: () -> Unit
) {

    composable(
        route = Constants.SPLASH_SCREEN,
        exitTransition ={_,_->
            slideOutVertically(
                targetOffsetY={it},
                animationSpec = tween(2000)
            )
        }
    ) { navigate ->
        splashSCreen(navigateToListScreen=navigateToTaskScreen)
    }
}