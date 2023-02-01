package com.sabekur2017.composeuipractice.uicomponent

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp


@Composable
fun DrawSimpleCircle(
    color: Color,
    modifier: Modifier = Modifier,
    minSize: Dp = Dp(32.0F)
) {
    Canvas(modifier = modifier.size(minSize)) {
        drawCircle(color)
    }
}