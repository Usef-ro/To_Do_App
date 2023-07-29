package com.example.to_docompose.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listScreen(
    navigateToTaskScreen:(Int)->Unit
) {
        Scaffold(

            content = {}
            , floatingActionButton = {
                ListFab(onFabClick=navigateToTaskScreen)
            },
            topBar = {listAppBar()}
        )


}

@Composable
fun ListFab(
    onFabClick:(Int)->Unit
){
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
@Preview
fun prev(){
    listScreen(navigateToTaskScreen = {})
}