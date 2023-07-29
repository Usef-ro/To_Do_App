package com.example.to_docompose.navigation

import androidx.navigation.NavHostController
import com.example.to_docompose.util.Constants.LIST_SCREEN

class screen(navController: NavHostController) {

    val list:(action)->Unit={action->
        navController.navigate("list/${action.name}"){
            popUpTo(LIST_SCREEN){
                inclusive=true
            }
        }
    }

    val task:(Int)->Unit={taskId->
        navController.navigate("list/${taskId}")
    }
}