package com.example.to_docompose.ui.screens.task

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.to_docompose.data.domain.model.ToDoTask
import com.example.to_docompose.navigation.action
import com.example.to_docompose.ui.viewModel.viewModell

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun taskScreen(
    navigationToListScreen: (action) -> Unit,
    selectedTask: ToDoTask?,
    viewModell: viewModell
) {

    val title by viewModell.title
    val desc by viewModell.desc
    val priority by viewModell.priority

    val context = LocalContext.current
    Scaffold(
        topBar = {
            taskAppBar(
                navigationToListScreen = { action ->
                    if (action == com.example.to_docompose.navigation.action.NO_ACTION) {
                        navigationToListScreen(action)
                    } else {
                        if (viewModell.validationField()) {
                            navigationToListScreen(action)
                        } else {
                            showMessage(context)
                        }
                    }
                },
                selectedTask = selectedTask
            )
        },
        content = {

            Box(modifier = Modifier.padding(it)) {
                taskContent(title = title,
                    onTitleChange = { viewModell.updateTitle(it) },
                    description = desc,
                    onDescriptionChange = { viewModell.desc.value = it },
                    priority = priority,
                    onPrioritySelected = { viewModell.priority.value = it })
            }

        }
    )

}

fun showMessage(context: Context) {
    Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show()
}