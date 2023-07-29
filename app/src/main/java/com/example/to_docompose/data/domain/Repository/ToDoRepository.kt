package com.example.to_docompose.data.domain.Repository

import com.example.to_docompose.data.domain.model.ToDoDao
import com.example.to_docompose.data.domain.model.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ViewModelScoped
class ToDoRepository @Inject constructor(val toDoDao: ToDoDao) {

    val getAllTasks: Flow<List<ToDoTask>> = toDoDao.getAllTasks()
    val sortByLow:Flow<List<ToDoTask>> = toDoDao.sortByLowPriority()
    val sortByHigh:Flow<List<ToDoTask>> = toDoDao.sortByHighPriority()

    fun getSelectedTasks(task:Int): Flow<ToDoTask> {
        return toDoDao.getSelectedTasks(taskId = task)
    }

    suspend fun addTask(task:ToDoTask){
        toDoDao.addTask(toDoTask = task)
    }
    suspend fun updateTask(task:ToDoTask){
        toDoDao.updateTask(toDoTask = task)
    }

    suspend fun removeTask(task:ToDoTask){
        toDoDao.deleteTask(taskId = task)
    }

    suspend fun deleteAll(){
        toDoDao.deleteAllTasks()
    }

    fun searchDataBase(searchQuery:String):Flow<List<ToDoTask>>{
        return toDoDao.searchDatabase(searchQuery)
    }



}