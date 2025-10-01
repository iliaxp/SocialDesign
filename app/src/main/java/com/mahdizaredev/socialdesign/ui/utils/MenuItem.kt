package com.mahdizaredev.socialdesign.ui.utils

import com.mahdizaredev.socialdesign.R

open class MenuItem(var route: String, var icon: Int, var title: String) {
    object Home: MenuItem("home", R.drawable.ic_home,"Home")
    object Explore: MenuItem("explore", R.drawable.ic_explore,"Explore")
    object Add: MenuItem("add", R.drawable.ic_add,"Add")
    object Activities: MenuItem("activities", R.drawable.ic_like,"Activities")
    object Profile: MenuItem("profile", R.drawable.ic_profile,"Profile")
}