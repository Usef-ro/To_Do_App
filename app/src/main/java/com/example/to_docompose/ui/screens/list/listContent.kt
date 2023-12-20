package com.example.to_docompose.ui.screens.list

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.to_docompose.data.domain.model.Priority
import com.example.to_docompose.data.domain.model.ToDoTask
import com.example.to_docompose.ui.theme.HighPriorityColor
import com.example.to_docompose.ui.theme.LARGE_PADDING
import com.example.to_docompose.ui.theme.PRIORITY_INDICATORE_SIZE
import com.example.to_docompose.util.requestState

@Composable
fun listContent(
    toDoTask: requestState<List<ToDoTask>>,
    navigationToTaskScreen: (taskId: Int) -> Unit,
    padding: PaddingValues,
    searchedTasks: requestState<List<ToDoTask>>,
    searchAppBarState: searchAppBarStatus
) {
    Log.e("searchAppBarState", "" + searchAppBarState)
    if (searchAppBarState == searchAppBarStatus.TRIGGERED) {

        if (searchedTasks is requestState.success) {
            hanldeListContent(
                task = searchedTasks.data,
                navigationToTaskScreen = navigationToTaskScreen,
                padding = padding
            )
        }
    } else {
        if (toDoTask is requestState.success) {
            hanldeListContent(
                task = toDoTask.data,
                navigationToTaskScreen = navigationToTaskScreen,
                padding = padding
            )
        }

    }
}

@Composable
fun hanldeListContent(
    task: List<ToDoTask>,
    navigationToTaskScreen: (taskId: Int) -> Unit,
    padding: PaddingValues
) {

    if (task.isEmpty()) {

        emptyContent(padding = padding)
    } else {
        listTask(
            toDoTask = task,
            navigationToTaskScreen = navigationToTaskScreen,
            padding = padding
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listTask(
    toDoTask: List<ToDoTask>,
    navigationToTaskScreen: (taskId: Int) -> Unit,
    padding: PaddingValues
) {
    LazyColumn(modifier = Modifier.padding(padding)) {

        itemsIndexed(toDoTask) { index, item ->

            val dismissState = rememberDismissState()
            val degrees by animateFloatAsState(
                targetValue =
                if (dismissState.targetValue == DismissValue.Default)
                    0f
                else
                    -45f
            )
            SwipeToDismiss(dismissContent = {
                taskItem(toDoTask = item, navigationToTaskScreen = navigationToTaskScreen)
            },
//                dismissThresholds = { FractionalThreshold(0.2f) },
                state = dismissState, background = { redBackground(degress = degrees) },
                directions = setOf(DismissDirection.EndToStart))

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun taskItem(
    toDoTask: ToDoTask,
    navigationToTaskScreen: (taskId: Int) -> Unit
) {

    Surface(
        onClick = { navigationToTaskScreen(toDoTask.id) },
        color = MaterialTheme.colorScheme.onSecondary,
        shape = RectangleShape,
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 2.dp
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = LARGE_PADDING)
        ) {


            Row {
                Text(
                    modifier = Modifier.weight(8f),
                    text = toDoTask.title, style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold, maxLines = 1
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.TopEnd
                ) {
                    Canvas(
                        modifier = Modifier
                            .width(PRIORITY_INDICATORE_SIZE)
                            .height(PRIORITY_INDICATORE_SIZE)
                    ) {
                        drawCircle(
                            color = toDoTask.priority.color
                        )
                    }
                }
            }

            Text(
                text = toDoTask.description,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Normal,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun redBackground(degress: Float) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HighPriorityColor)
            .padding(horizontal = LARGE_PADDING),
        contentAlignment = Alignment.CenterEnd
    ) {
        Icon(
            imageVector = Icons.Filled.Delete,
            modifier = Modifier.rotate(degrees = degress),
            contentDescription = "",
            tint = Color.White
        )
    }
}

@Composable
@Preview
fun prev7() {
    taskItem(
        toDoTask = ToDoTask(0, "thft", "hhjk", priority = Priority.MEDIUM),
        navigationToTaskScreen = {})
}