package com.mahdizaredev.socialdesign.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.mahdizaredev.socialdesign.R

@Composable
fun UserCircleProfile(
    profileImage: String,
    username: String,
    size: Dp,
    borderStroke: BorderStroke
) {
    Card(
        shape = CircleShape,
        border = borderStroke,
        modifier = Modifier.padding(6.dp)
    ) {
        Box(Modifier.size(size), contentAlignment = Alignment.Center) {
            var loading by remember { mutableStateOf(false) }
            AsyncImage(
                model = profileImage,
                contentDescription = username,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                error = painterResource(R.drawable.error),
                onLoading = { loading = true },
                onError = { loading = false },
                onSuccess = { loading = false }
            )
            if (loading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Loading()
                }
            }
        }
    }
}