package com.example.to_docompose.ui.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_docompose.data.domain.Repository.ToDoRepository
import com.example.to_docompose.data.domain.model.Priority
import com.example.to_docompose.data.domain.model.ToDoTask
import com.example.to_docompose.navigation.action
import com.example.to_docompose.ui.screens.list.searchAppBarStatus
import com.example.to_docompose.util.requestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class viewModell @Inject constructor(
    private val toDoRepository: ToDoRepository
) : ViewModel() {

    val action: MutableState<action> =
        mutableStateOf(com.example.to_docompose.navigation.action.NO_ACTION)
    var id: MutableState<Int> = mutableStateOf(0)
    var title: MutableState<String> = mutableStateOf("")
    var desc: MutableState<String> = mutableStateOf("")
    var priority: MutableState<Priority> = mutableStateOf(Priority.LOW)

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
        } catch (e: Exception) {
            requestState.error(e)
        }
    }

    val _searcheTask: MutableStateFlow<requestState<List<ToDoTask>>> = MutableStateFlow(requestState.idle)
    val searched:StateFlow<requestState<List<ToDoTask>>> = _searcheTask


    fun searchDataBase(search:String) {
        try {
            viewModelScope.launch {
                _searcheTask.value=requestState.loading
                toDoRepository.searchDataBase(searchQuery = "%$search%").collect{
                    _searcheTask.value = requestState.success(it)
                }
            }
        } catch (e: Exception) {
            _searcheTask.value=requestState.error(e)
        }
        serchAppBarState.value=searchAppBarStatus.TRIGGERED
    }


    val _selectedTasks: MutableStateFlow<ToDoTask?> = MutableStateFlow(null)
    val selected:StateFlow<ToDoTask?> = _selectedTasks

    fun getSelectedTask(task: Int) {
        viewModelScope.launch {
            toDoRepository.getSelectedTasks(task = task).collect { task ->
                _selectedTasks.value = task
            }
        }
    }


    fun selectedTask(toDoTask: ToDoTask?) {
        if (toDoTask != null) {

            id.value = toDoTask.id
            title.value = toDoTask.title
            desc.value = toDoTask.description
            priority.value = toDoTask.priority
        } else {
            id.value = 0
            title.value = ""
            desc.value = ""
            priority.value = Priority.LOW
        }
    }

    fun updateTitle(newTitle: String) {
        if (newTitle.length < 15) {
            title.value = newTitle
        }
    }

    fun validationField(): Boolean {
        return title.value.isNotEmpty() && desc.value.isNotEmpty()
    }

    fun addTask() {
        viewModelScope.launch(Dispatchers.IO) {
            val toDoTask = ToDoTask(
                title = title.value,
                description = desc.value,
                priority = priority.value
            )
            toDoRepository.addTask(task = toDoTask)
        }
    }

    fun handleDataBaseAction(action: action) {
        when (action) {
            com.example.to_docompose.navigation.action.ADD -> {
                addTask()
            }

            com.example.to_docompose.navigation.action.UPDATE -> {
                updateTask()
            }

            com.example.to_docompose.navigation.action.DELETE -> {
                deleteTask()
            }

            com.example.to_docompose.navigation.action.UNOD -> {
                addTask()
            }
            com.example.to_docompose.navigation.action.DELETEALL->{
                deleteAll()
            }

            else -> {

            }
        }
        this.action.value = com.example.to_docompose.navigation.action.NO_ACTION
    }

    fun updateTask() {
        viewModelScope.launch(Dispatchers.IO) {
            val toDoTask = ToDoTask(
                id = id.value,
                title = title.value,
                description = desc.value,
                priority = priority.value
            )
            toDoRepository.updateTask(task = toDoTask)
        }
    }

    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO) {
            toDoRepository.deleteAll()
        }
    }
    fun deleteTask() {
        viewModelScope.launch(Dispatchers.IO) {
            val toDoTask = ToDoTask(
                id = id.value,
                title = title.value,
                description = desc.value,
                priority = priority.value
            )
            toDoRepository.deleteTask(task = toDoTask)
        }
    }

}