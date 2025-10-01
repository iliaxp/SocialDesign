package com.mahdizaredev.socialdesign.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.mahdizaredev.socialdesign.ui.component.PostItem
import com.mahdizaredev.socialdesign.vm.PostsViewModel

@Composable
fun PostDetailScreen(
    navController: NavHostController,
    startIndex: Int,
    viewModel: PostsViewModel = viewModel()
) {
    val posts = viewModel.posts
    val listState = rememberLazyListState(initialFirstVisibleItemIndex = startIndex)

    LazyColumn(state = listState) {
        items(posts.size) { index ->
            PostItem(posts[index], navController)
        }
    }
}
