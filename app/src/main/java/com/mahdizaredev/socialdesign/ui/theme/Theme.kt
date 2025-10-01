package com.mahdizaredev.socialdesign.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary = BlackBackground,
    onPrimary = WhiteBackground,
    background = WhiteBackground,
    surface = WhiteBackground,
    onBackground = BlackBackground,
    onSurface = BlackBackground
)

private val DarkColors = darkColorScheme(
    primary = WhiteBackground,
    onPrimary = BlackBackground,
    background = BlackBackground,
    surface = BlackBackground,
    onBackground = WhiteBackground,
    onSurface = WhiteBackground
)

@Composable
fun SocialDesignTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = MaterialTheme.typography, // اگر تایپوگرافی خاص داری اینجا بزار
        shapes = MaterialTheme.shapes,
        content = content
    )
    }