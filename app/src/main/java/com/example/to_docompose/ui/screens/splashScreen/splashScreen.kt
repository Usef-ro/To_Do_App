package com.example.to_docompose.ui.screens.splashScreen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.R
import kotlinx.coroutines.delay

@Composable
fun splashSCreen(
    navigateToListScreen:()->Unit
){
    LaunchedEffect(key1 =true ){
        delay(3000L)
        navigateToListScreen()
    }
    Box(contentAlignment = Alignment.Center,modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primary)){
        Image(painter = painterResource(id =R.drawable.ic_launcher_background )
            , contentDescription ="Logo" )
    }
}

