package com.mahdizaredev.socialdesign.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mahdizaredev.socialdesign.ui.utils.MenuItem
import okhttp3.internal.wait

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val menu = listOf(
        MenuItem.Home,
        MenuItem.Explore,
        MenuItem.Add,
        MenuItem.Activities,
        MenuItem.Profile
    )

    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = navBackStackEntry?.destination?.route

    val backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.White
    val dividerColor = if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray

    Column {
        HorizontalDivider(
            color = dividerColor,
            thickness = 0.5.dp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .background(backgroundColor)
                .padding(bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            menu.forEach { item ->
                val selected = currentRoute == item.route
                val iconColor =
                    if (selected) if (isSystemInDarkTheme()) Color.White else Color.Black
                    else Color.Gray

                val interactionSource = remember { MutableInteractionSource() }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    contentAlignment = Alignment.TopCenter // آیکون دقیقاً وسط Box
                ) {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier.size(24.dp) // 👈 اندازه مناسب آیکون
                    )
                }
            }
        }
    }
}


