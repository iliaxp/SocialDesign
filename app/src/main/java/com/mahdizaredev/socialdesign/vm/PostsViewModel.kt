package com.mahdizaredev.socialdesign.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahdizaredev.socialdesign.data.MockDataRepository
import com.mahdizaredev.socialdesign.data.model.Post
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PostsViewModel : ViewModel() {
    private val _posts = mutableStateListOf<Post>()
    val posts: List<Post> get() = _posts

    private var currentPage = 0
    private val pageSize = 10
    var isLoading by mutableStateOf(false)
        private set

    init {
        loadMorePosts()
    }

    fun loadMorePosts() {
        if (isLoading) return
        isLoading = true
        viewModelScope.launch {
            delay(500) // شبیه سازی تاخیر شبکه
            val newPosts = MockDataRepository.getRandomPost(currentPage, pageSize)
            _posts.addAll(newPosts)
            currentPage++
            isLoading = false
        }
    }

    fun refreshPosts() {
        viewModelScope.launch {
            _posts.clear()
            currentPage = 0
            loadMorePosts()
        }
    }
}

