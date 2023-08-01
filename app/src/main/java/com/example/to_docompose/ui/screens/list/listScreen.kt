package com.example.to_docompose.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.to_docompose.ui.viewModel.viewModell

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listScreen(
    navigateToTaskScreen: (taskId:Int) -> Unit
    , viewModell: viewModell
) {

    val searchAppBarStatus:searchAppBarStatus by viewModell.serchAppBarState
    val searchText:String by viewModell.searchText

    Scaffold(

        content = {
                  listContent()
        }, floatingActionButton = {
            ListFab(onFabClick = navigateToTaskScreen)
        },
        topBar = { listAppBar(viewModell=viewModell, seachAppBarStatus =searchAppBarStatus, searchText = searchText) }
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

