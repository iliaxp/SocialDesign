package com.mahdizaredev.socialdesign.ui.screen

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.mahdizaredev.socialdesign.data.MockDataRepository
import com.mahdizaredev.socialdesign.ui.component.Loading
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SingleStoryView(id: Int, navController: NavHostController) {
    val story = MockDataRepository.getStoryById(id)
    if(story == null){
        navController.popBackStack()
        return
    }
    var loading by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
        
    ) {
        AsyncImage(
            model = story.storyImage,
            contentDescription = story.username,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize(),
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