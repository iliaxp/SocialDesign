package com.mahdizaredev.socialdesign.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mahdizaredev.socialdesign.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar() {

    TopAppBar(
        title = {

            Image(
                painterResource(R.drawable.topbar),
                contentDescription = "Application Icon",
                colorFilter = ColorFilter.tint(
                    if (isSystemInDarkTheme()) Color.White else Color.Black
                ),
                modifier = Modifier.width(100.dp)
            )
        },
        actions = {
            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(R.drawable.ic_send),
                    contentDescription = "Search Icon"
                )
            }
        },
    )

}