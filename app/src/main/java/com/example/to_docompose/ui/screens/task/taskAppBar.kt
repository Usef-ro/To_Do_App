package com.example.to_docompose.ui.screens.task

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.data.domain.model.Priority
import com.example.to_docompose.data.domain.model.ToDoTask
import com.example.to_docompose.navigation.action

@Composable
fun taskAppBar(navigationToListScreen: (action) -> Unit, selectedTask: ToDoTask?) {

    if (selectedTask == null) {

        newTaskAppBar(navigationToListScreen = navigationToListScreen)
    } else {
        existAppBar(selectedTask = selectedTask, navigationToListScreen = navigationToListScreen)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun newTaskAppBar(navigationToListScreen: (action) -> Unit) {
    TopAppBar(title = {
        Text(text = "Add Task")
    },
        navigationIcon = {
            backAction(onBackClick = navigationToListScreen)
        },

        actions = {
            addAction(onBackClick = navigationToListScreen)
        }
    )

}

@Composable
fun backAction(
    onBackClick: (action) -> Unit
) {
    IconButton(onClick = {

        onBackClick(action.NO_ACTION)

    }) {
        Icon(
//            tint=MaterialTheme.colorScheme.onPrimary,
            imageVector = Icons.Filled.ArrowBack, contentDescription = "Back"
        )


    }

}


@Composable
fun addAction(
    onBackClick: (action) -> Unit
) {
    IconButton(onClick = {

        onBackClick(action.ADD)

    }) {

        Icon(
//            tint=MaterialTheme.colorScheme.onPrimary,
            imageVector = Icons.Filled.Check, contentDescription = "Back"
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun existAppBar(
    selectedTask: ToDoTask,
    navigationToListScreen: (action) -> Unit
) {
    TopAppBar(title = {
        Text(text = selectedTask.title, maxLines = 1, overflow = TextOverflow.Ellipsis)
    },
        navigationIcon = {
            closeAction(onCloseClick = navigationToListScreen)
        },

        actions = {
            deleteAction(onDeleteClick = navigationToListScreen)
            updateAction(onUpdateClick = navigationToListScreen)
        }
    )

}

@Composable
fun closeAction(
    onCloseClick: (action) -> Unit
) {
    IconButton(onClick = {

        onCloseClick(action.NO_ACTION)

    }) {

        Icon(
//            tint=MaterialTheme.colorScheme.onPrimary,
            imageVector = Icons.Filled.Close, contentDescription = "Close"
        )
    }

}

@Composable
fun deleteAction(
    onDeleteClick: (action) -> Unit
) {
    IconButton(onClick = {

        onDeleteClick(action.DELETE)

    }) {

        Icon(
//            tint=MaterialTheme.colorScheme.onPrimary,
            imageVector = Icons.Filled.Delete, contentDescription = "Delete"
        )
    }

}

@Composable
fun updateAction(
    onUpdateClick: (action) -> Unit
) {
    IconButton(onClick = {

        onUpdateClick(action.UPDATE)

    }) {

        Icon(
//            tint=MaterialTheme.colorScheme.onPrimary,
            imageVector = Icons.Filled.Check, contentDescription = "Check"
        )
    }

}

@Composable
@Preview

fun prev8() {
    taskAppBar(
        navigationToListScreen = {},
        selectedTask = ToDoTask(id = 0, title = "pop", description = "Pop", priority = Priority.LOW)
    )
}

@Composable
@Preview

fun prev9() {
    existAppBar(selectedTask = ToDoTask(
        id = 0,
        title = "pop",
        description = "Pop",
        priority = Priority.LOW
    ),
        navigationToListScreen = {})
}
