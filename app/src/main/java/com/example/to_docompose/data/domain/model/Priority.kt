package com.example.to_docompose.data.domain.model

import androidx.compose.ui.graphics.Color
import com.example.to_docompose.ui.theme.HighPriorityColor
import com.example.to_docompose.ui.theme.LowPriorityColor
import com.example.to_docompose.ui.theme.MediumPriorityColor
import com.example.to_docompose.ui.theme.NonePriorityColor

enum class Priority(var color:Color) {
HIGH(HighPriorityColor)
, MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}