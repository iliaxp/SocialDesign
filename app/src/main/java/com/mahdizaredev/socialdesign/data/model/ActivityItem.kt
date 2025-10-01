package com.mahdizaredev.socialdesign.data.model

import com.mahdizaredev.socialdesign.data.model.enums.ActivityType

data class ActivityItem(
    val username: String,
    val userProfile: String,
    val type: ActivityType,
    val time: String,
    val postThumbnail: String? = null,

    )