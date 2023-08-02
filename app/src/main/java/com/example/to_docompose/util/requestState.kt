package com.example.to_docompose.util

import com.example.to_docompose.data.domain.model.ToDoTask

sealed class requestState<out T>{
    object idle:requestState<Nothing>()
    object loading:requestState<Nothing>()
    data class success(val data:List<ToDoTask>):requestState<Nothing>()
    data class error(val error:Throwable):requestState<Nothing>()
}