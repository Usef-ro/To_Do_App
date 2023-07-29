package com.example.to_docompose.ui.screens.list


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.to_docompose.data.domain.model.Priority
import com.example.to_docompose.ui.theme.LARGE_PADDING
import com.example.to_docompose.ui.theme.PRIORITY_INDICATORE_SIZE


@Composable
fun priorityItem(priority: Priority){
    Row(
        verticalAlignment=Alignment.CenterVertically
    ) {
        Canvas(modifier = Modifier.size(PRIORITY_INDICATORE_SIZE) ){
            drawCircle(color=priority.color)
        }
        Text(text = priority.name
            ,Modifier.padding(start=LARGE_PADDING)
            ,color = MaterialTheme.colorScheme.onSurface,
            style=MaterialTheme.typography.titleSmall)

    }
}

@Composable
@Preview
fun pr(){
    priorityItem(priority = Priority.HIGH)
}