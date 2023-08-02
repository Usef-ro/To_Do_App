package com.example.to_docompose.ui.screens.list


import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.to_docompose.R

@Composable
fun emptyContent(){
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth(),
        verticalArrangement =Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
Icon(painterResource(id = R.drawable.
baseline_sentiment_very_dissatisfied_24),
    contentDescription = "Sad Face",
    modifier = Modifier.size(120.dp))
        
        Text(text = "No Task"
            ,fontWeight=FontWeight.Bold,
            fontSize =MaterialTheme.typography.bodyMedium.fontSize,
            color = MaterialTheme.colorScheme.onSecondary)
        }

}

@Composable
@Preview
fun prev8(){
    emptyContent()
}