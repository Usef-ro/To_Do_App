package com.example.to_docompose.ui.screens.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.to_docompose.components.priorityItemScreen
import com.example.to_docompose.data.domain.model.Priority
import com.example.to_docompose.ui.theme.LARGE_PADDING
import com.example.to_docompose.ui.theme.MEDIUM_PADDING


@Composable
fun taskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit,

    ) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = LARGE_PADDING)

    ) {


        OutlinedTextField(value = title,
            label = {
                Text(text = "Title")
            },
            textStyle = MaterialTheme.typography.bodyLarge,
            singleLine = true, onValueChange = { onTitleChange(it) })

        Divider(
            modifier = Modifier.height(MEDIUM_PADDING)
        )
        priorityItemScreen(
            priority = priority,
            onPrioritySelected = onPrioritySelected
        )
        Divider(
            modifier = Modifier.height(MEDIUM_PADDING)
        )
        OutlinedTextField(
            value = description,
            modifier = Modifier.fillMaxSize(),
            onValueChange = {
                onDescriptionChange(it)
            },
            label = { Text(text = "Description") },
        )
    }
}