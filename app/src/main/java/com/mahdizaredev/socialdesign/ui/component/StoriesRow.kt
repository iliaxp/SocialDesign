package com.mahdizaredev.socialdesign.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.mahdizaredev.socialdesign.data.MockDataRepository
import com.mahdizaredev.socialdesign.data.model.Story

@Composable
fun StoriesRow(navController: NavHostController) {
    LazyRow {
        item {
            val story by rememberSaveable {
                mutableStateOf(
                    Story(
                        -1,
                        "Your Story",
                        "https://avatars.githubusercontent.com/u/190405738?v=4",
                        ""
                    )
                )
            }
            StoryItem(story, navController)
        }
        items(10) {
            var story by rememberSaveable { mutableStateOf(MockDataRepository.getRandomStory()) }
            StoryItem(story, navController)
        }
    }
}

@Composable
fun StoryItem(story: Story, navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { navController.navigate("story/" + story.id) }) {
        UserCircleProfile(
            story.profileImage,
            story.username,
            80.dp,
            BorderStroke(4.dp, Color.Red)
        )
        Spacer(Modifier.height(2.dp))
        Text(story.username, color = Color.DarkGray)
    }
}