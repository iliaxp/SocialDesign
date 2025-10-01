package com.mahdizaredev.socialdesign.ui.screen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mahdizaredev.socialdesign.ui.component.PostsView
import com.mahdizaredev.socialdesign.ui.component.StoriesRow

@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        StoriesRow(navController)
        Spacer(Modifier.width(9.dp))
        HorizontalDivider(
            color = Color.Gray,
            thickness = 1.dp
        )
        Spacer(Modifier.width(8.dp))
        PostsView(navController)
    }
}