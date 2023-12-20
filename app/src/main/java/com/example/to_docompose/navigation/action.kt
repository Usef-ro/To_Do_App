package com.example.to_docompose.navigation

enum class action {
    ADD,
    UPDATE,
    DELETE,
    DELETEALL,
    UNOD,
    NO_ACTION
}

fun String?.action(): action {
    return when {
        this == "ADD" -> {
            action.ADD
        }

        this == "DELETEALL" -> {
            action.DELETEALL
        }

        this == "UPDATE" -> {
            action.UPDATE
        }

        this == "DELETE" -> {
            action.DELETE
        }

        this == "NO_ACTION" -> {
            action.NO_ACTION
        }

        this == "UNOD" -> {
            action.UNOD
        }

        else -> {
            action.NO_ACTION
        }
    }
}