package com.mahdizaredev.socialdesign.data.model

import java.io.Serializable

data class Post(
    var id: Int,
    var username: String,
    var userprofile: String,
    var image: String,
    val caption: String
): Serializable