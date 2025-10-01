package com.mahdizaredev.socialdesign.ui.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mahdizaredev.socialdesign.R

@Composable
fun Loading() {
    val transition = rememberInfiniteTransition()
    val rotate by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box(
        modifier = Modifier
            .size(24.dp)
            .graphicsLayer(rotationZ = rotate), // یا rotate(rotate)
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_loading),
            contentDescription = "Loading Icon",
            modifier = Modifier
                .size(50.dp)
                .rotate(rotate) // اینجا مستقیم rotate می‌کنیم
        )
    }
}