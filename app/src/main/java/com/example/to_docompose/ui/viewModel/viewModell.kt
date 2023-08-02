package com.example.to_docompose.ui.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_docompose.data.domain.Repository.ToDoRepository
import com.example.to_docompose.data.domain.model.ToDoTask
import com.example.to_docompose.ui.screens.list.searchAppBarStatus
import com.example.to_docompose.util.requestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class viewModell @Inject constructor(
    private val toDoRepository: ToDoRepository
) : ViewModel() {

    val serchAppBarState: MutableState<searchAppBarStatus> =
        mutableStateOf(searchAppBarStatus.CLOSED)

    fun setserchAppBarState() {
        serchAppBarState.value = searchAppBarStatus.OPENED
    }

    val searchText: MutableState<String> = mutableStateOf("")

    val _allTasks =
        MutableStateFlow<requestState<List<ToDoTask>>>(requestState.idle)

    val allTasks: StateFlow<requestState<List<ToDoTask>>> = _allTasks

    fun getAllTask() {
       try {
           viewModelScope.launch {
               toDoRepository.getAllTasks.collect {
                   _allTasks.value = requestState.success(it)
               }
           }
       }catch (e: Exception){
           requestState.error(e)
       }
    }

    val _selectedTasks:MutableStateFlow<ToDoTask?> =MutableStateFlow(null)
    val selected:StateFlow<ToDoTask?> = _selectedTasks

    fun getSelectedTask(task:Int){
        viewModelScope.launch {
            toDoRepository.getSelectedTasks(task = task).collect {task->
            _selectedTasks.value = task
            }
        }
    }

}