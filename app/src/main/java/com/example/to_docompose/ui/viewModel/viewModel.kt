package com.example.to_docompose.ui.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_docompose.data.domain.Repository.ToDoRepository
import com.example.to_docompose.data.domain.model.ToDoTask
import com.example.to_docompose.ui.screens.list.searchAppBarStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.mutableStateOf

@HiltViewModel
class viewModel @Inject constructor(private val toDoRepository: ToDoRepository) : ViewModel() {

    val serchAppBarState:MutableState<searchAppBarStatus> = mutableStateOf(searchAppBarStatus.CLOSED)

    val searchText :MutableState<String> = mutableStateOf("")

    val _allTasks = MutableStateFlow<List<ToDoTask>>(emptyList())

    val allTasks: StateFlow<List<ToDoTask>> = _allTasks

    fun getAllTask() {
        viewModelScope.launch {
            toDoRepository.getAllTasks.collect({
                _allTasks.value = it
            })
        }
    }


}