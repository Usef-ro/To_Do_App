package com.example.to_docompose.navigation

enum class action {
    ADD,
    UPDATE,
    DELETE,
    UNOD,
    NO_ACTION
}

fun String?.action(): action {
    return when {
        this == "ADD" -> {
            action.ADD
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