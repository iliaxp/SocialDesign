package com.mahdizaredev.socialdesign.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.mahdizaredev.socialdesign.data.MockDataRepository
import com.mahdizaredev.socialdesign.ui.component.Loading
import com.mahdizaredev.socialdesign.vm.PostsViewModel

@Composable
fun ExploreScreen(navController: NavHostController) {
    val images = List(99) { MockDataRepository.getImage() }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        contentPadding = PaddingValues(2.dp)
    ) {
        items(images.size) { index ->
            val currentImage = images[index]
            AsyncImage(
                model = currentImage,
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
        }
    }
}
