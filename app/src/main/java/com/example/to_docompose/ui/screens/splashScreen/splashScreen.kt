package com.example.to_docompose.ui.screens.splashScreen

import android.view.textclassifier.SelectionEvent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.to_docompose.R
import kotlinx.coroutines.delay

@Composable
fun splashSCreen(
    navigateToListScreen: () -> Unit
) {
    LaunchedEffect(key1 = true) {

        delay(3000L)
        navigateToListScreen()

    }
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary.copy(0.5f))
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_note),
            modifier = Modifier.size(150.dp),
            contentDescription = "Logo"
        )
    }
}

