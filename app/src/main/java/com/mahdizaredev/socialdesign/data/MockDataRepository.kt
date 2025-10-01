package com.mahdizaredev.socialdesign.data

import com.mahdizaredev.socialdesign.data.model.ActivityItem
import com.mahdizaredev.socialdesign.data.model.Post
import com.mahdizaredev.socialdesign.data.model.Story
import com.mahdizaredev.socialdesign.data.model.enums.ActivityType
import kotlin.random.Random


class MockDataRepository {
    companion object {


        private val stories = mutableListOf<Story>()
        private val posts = mutableListOf<Post>()
        private var id: Int = 0
        private fun getId(): Int {
            id++
            return id
        }

        private fun getAvatar(): String {
            val gender = if (Random.nextBoolean()) "women" else "men"
            // randomuser.me portraits require a file extension
            return "https://randomuser.me/portraits/${gender}/${Random.nextInt(1, 100)}.jpg"
        }

        fun getImage(): String {
            return "https://picsum.photos/id/${Random.nextInt(1, 100)}/500/500"
        }

        fun getStoryImage(): String {
            return "https://picsum.photos/id/${Random.nextInt(1, 100)}/540/960"
        }

            fun getRandomStory(): Story {
                val result = Story(
                    getId(),
                    MockNameRepository().getRandomName(),
                    getAvatar(),
                    getStoryImage()

                )
                stories.add(result)
                return result
            }

        fun getRandomPost(page: Int, pageSize: Int): List<Post> {
            val newPosts = mutableListOf<Post>()
            repeat(pageSize) {
                val post = Post(
                    getId(),
                    MockNameRepository().getRandomName(),
                    getAvatar(),
                    getImage(),
                    MockStringRepository().getRandomCaption()
                )
                posts.add(post)
                newPosts.add(post)
            }
            return newPosts
        }

        fun getStoryById(id: Int): Story? {
            return stories.firstOrNull { it.id == id }
        }

        fun getRandomActivities(): ActivityItem {
            val types = ActivityType.entries.toTypedArray()
            val randomType = types.random()   // انتخاب تصادفی یکی از آن‌ها
            return ActivityItem(
                MockNameRepository().getRandomName(),
                getAvatar(),
                randomType,
                "${Random.nextInt(1, 23)}h",
                getImage()
            )
        }

        fun getRandomActivityType(): ActivityType {
            val rnd = Random.nextInt(1, 100)
            return if (rnd % 5 == 0) {
                ActivityType.Comment
            } else if (rnd % 3 == 0) {
                ActivityType.Follow
            } else {
                ActivityType.Like
            }
        }

    }
}