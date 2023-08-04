package com.example.to_docompose.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.example.to_docompose.navigation.action
import com.example.to_docompose.ui.viewModel.viewModell
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun listScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit, viewModell: viewModell
) {

    LaunchedEffect(key1 = true) {
        viewModell.getAllTask()
    }

    val action by viewModell.action
    val allTAsks by viewModell.allTasks.collectAsState()
    val searchAppBarStatus: searchAppBarStatus by viewModell.serchAppBarState
    val searchText: String by viewModell.searchText

    viewModell.handleDataBaseAction(action)

    Scaffold(
        content = {
            listContent(toDoTask = allTAsks, navigationToTaskScreen = navigateToTaskScreen, it)
        },
        floatingActionButton = {
            ListFab(onFabClick = navigateToTaskScreen)
        },
        topBar = {
            listAppBar(
                viewModell = viewModell,
                seachAppBarStatus = searchAppBarStatus,
                searchText = searchText
            )
        }
    )


}


@Composable
fun ListFab(
    onFabClick: (Int) -> Unit
) {
    FloatingActionButton(onClick = {
        onFabClick(-1)
    }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add "
        )
    }
}


@Composable
fun snakBar(
//scaffold:ScaffoldDefaults,
handleDataBaseActions:()->Unit,
taskTitle:String,
action:action
){

    handleDataBaseActions()

    val scope= rememberCoroutineScope()
    LaunchedEffect(key1 = action ){
        if(action!=com.example.to_docompose.navigation.action.NO_ACTION){
            scope.launch {
//                val snackResult =scaffold.sna
            }
        }
    }

}

