package com.example.to_docompose.ui.screens.list

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.to_docompose.R
import com.example.to_docompose.data.domain.model.Priority
import com.example.to_docompose.navigation.action
import com.example.to_docompose.ui.viewModel.viewModell

@Composable
fun listAppBar(
    viewModell: viewModell,
    seachAppBarStatus: searchAppBarStatus,
    searchText: String
) {

    Log.e("listAppBar", "Seach" + viewModell.serchAppBarState)
    when (seachAppBarStatus) {

        searchAppBarStatus.CLOSED -> {
            defaultListAppBar(
                onDelete = { viewModell.action.value == action.DELETEALL },
                sort = {},
                onSearchClick = {
                    viewModell.serchAppBarState.value = searchAppBarStatus.OPENED


                })
        }

        else -> {
            seachAppBar(text = searchText, onTextChanged = { newValue ->
                viewModell.searchText.value = newValue
            }, onCloseClick = {
                viewModell.searchText.value = ""
                viewModell.serchAppBarState.value = searchAppBarStatus.CLOSED
            }, onSearchClick = {
                viewModell.searchDataBase(search = it)
            })
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun defaultListAppBar(onDelete: () -> Unit, sort: (Priority) -> Unit, onSearchClick: () -> Unit) {


    TopAppBar(
        title = {
            Text(text = "Task", color = MaterialTheme.colorScheme.primary)
        },
        actions = {
            ListAppBarActions(onDelete, sort, onSearchClick)
        },
        colors = topAppBarColors(
            MaterialTheme.colorScheme.onSecondary
        )
    )


}


@Composable
fun ListAppBarActions(onDelete: () -> Unit, sort: (Priority) -> Unit, onSearchClick: () -> Unit) {
    SearchActions(onSearchClick)
    sortActions(sort = sort)
    deleteAllAction(onDelete = onDelete)
}


@Composable
fun SearchActions(

    onSearchClick: () -> Unit
) {
    IconButton(onClick = onSearchClick) {

        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Search",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun sortActions(
    sort: (Priority) -> Unit,

    ) {


    var expand by remember {
        mutableStateOf(false)
    }
    IconButton(onClick = { expand = true }) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_filter_list_24),
            contentDescription = "Sort"
        )
        DropdownMenu(expanded = expand, onDismissRequest = { expand = false }) {


//            listItem.forEachIndexed { index, s ->
            DropdownMenuItem(
                colors = MenuDefaults.itemColors(textColor = Color.Black),
                text = { priorityItem(priority = Priority.LOW) },
                onClick = {
                    expand = false
                    sort(Priority.LOW)
                })

            DropdownMenuItem(
                text = { priorityItem(priority = Priority.MEDIUM) },
                onClick = {

                    expand = false
                })

            DropdownMenuItem(

                text = { priorityItem(priority = Priority.HIGH) },
                onClick = {
                    expand = false
                })

        }

    }
}

@Composable
fun deleteAllAction(
    onDelete: () -> Unit
) {
    var expand by remember {
        mutableStateOf(false)
    }
    IconButton(onClick = { expand = true }) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_more_vert_24),
            contentDescription = "Sort"
        )
        DropdownMenu(expanded = expand,
            onDismissRequest = { expand = false }) {

            DropdownMenuItem(
                text = {
                    Text(text = "delete")
                },
                onClick = {
                    onDelete()
                    expand = false
                })

        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun seachAppBar(
    text: String,
    onTextChanged: (String) -> Unit,
    onCloseClick: () -> Unit,
    onSearchClick: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
//        tonalElevation=
        color = MaterialTheme.colorScheme.onSecondary
    ) {

//        val containerColor = FilledTextFieldTokens.ContainerColor.toColor()
        TextField(value = text, modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search", color = Color.White) },
            onValueChange = { onTextChanged(it) },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.titleSmall.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        modifier = Modifier.alpha(2f), imageVector =
                        Icons.Filled.Search, contentDescription = "Search Icon",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }, trailingIcon = {
                IconButton(onClick = onCloseClick) {
                    Icon(
                        imageVector = Icons.Filled.Close, contentDescription = "close",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search,
            ), keyboardActions = KeyboardActions(
                onSearch = { onSearchClick(text) }
            ),
            colors = TextFieldDefaults.colors(
//                focusedContainerColor = containerColor,
//                unfocusedContainerColor = containerColor,
//                disabledContainerColor = containerColor,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
//        backgroundColor = Color.Transparent
                disabledIndicatorColor = Color.Transparent,
            )
        )

    }
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_NO)
fun prev1() {
    defaultListAppBar(onDelete = {}, sort = {}, onSearchClick = {

    })
}


@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun prev2() {
    defaultListAppBar(onDelete = {}, sort = {}, onSearchClick = {

    })
}


@Composable
@Preview
fun prev3() {
    defaultListAppBar(onDelete = {}, sort = {}, onSearchClick = {

    })
}


@Composable
@Preview
fun prev4() {
    seachAppBar(
        text = "Search",
        onTextChanged = {},
        onCloseClick = { /*TODO*/ },
        onSearchClick = {})
}