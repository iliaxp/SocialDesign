package com.mahdizaredev.socialdesign.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mahdizaredev.socialdesign.ui.component.BottomNavigationBar
import com.mahdizaredev.socialdesign.ui.component.TopNavBar
import com.mahdizaredev.socialdesign.ui.utils.MenuItem

@Composable
fun SocialDesignApp() {
    val navController = rememberNavController()
    var isFullScreen = checkForFullScreen(navController)
    Scaffold(
        topBar = { if(!isFullScreen) TopNavBar() },
        modifier = Modifier.fillMaxSize(),
        bottomBar = { if(!isFullScreen) BottomNavigationBar(navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavHost(navController, startDestination = "home") {
                composable(MenuItem.Home.route) { HomeScreen(navController) }
                composable(MenuItem.Explore.route) { ExploreScreen(navController) }
                composable(MenuItem.Add.route) { AddScreen(navController) }
                composable(MenuItem.Activities.route) { ActivitiesScreen(navController) }
                composable(MenuItem.Profile.route) { ProfileScreen(navController) }
                composable(
                    "story/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.IntType })
                ) {
                    val id = it.arguments?.getInt("id") ?: 0
                    SingleStoryView(id, navController)
                }
                composable("postDetail/{startIndex}") { backStackEntry ->
                    val startIndex = backStackEntry.arguments?.getString("startIndex")?.toInt() ?: 0
                    PostDetailScreen(navController, startIndex)
                }
            }
        }
    }
}

@Composable
fun checkForFullScreen(navController: NavHostController): Boolean {
    val fullScreenRoutes = listOf("story")
    val currentRoute =
        navController.currentBackStackEntryAsState().value?.destination?.route ?: "home"
    return fullScreenRoutes.any {
        currentRoute.startsWith(it)
    }
}