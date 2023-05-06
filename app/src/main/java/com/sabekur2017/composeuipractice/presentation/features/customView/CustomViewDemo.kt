package com.sabekur2017.composeuipractice.presentation.features.customView

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@Composable
fun CustomViewDemo() {
    Column(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Custom circle",
            style = TextStyle(color = Color.Black, textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomCircle(color = Color.Blue, modifier = Modifier.size(56.dp))
        Text(
            text = "Custom circle with gradient",
            style = TextStyle(color = Color.Black, textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomCircleWithGradient(centerColor = Color.Blue, outerColor = Color.Green)

        Text(
            text = "Custom rectangle",
            style = TextStyle(color = Color.Black, textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomRectangle(color = Color.Green)
        Text(
            text = "Custom rounded rectangle",
            style = TextStyle(color = Color.Black, textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomRoundedRectangle(color = Color.Green, cornerRadius = CornerRadius(x = 8.0f, y = 8.0f))

        Text(
            text = "Custom Line",
            style = TextStyle(color = Color.Black, textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomLine(color = Color.Blue)

        Text(
            text = "Custom Oval",
            style = TextStyle(color = Color.Black, textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomOval(color = Color.Blue)
        Text(
            text = "Custom Arc",
            style = TextStyle(color = Color.Black, textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomArc(color = Color.Blue)
        Text(
            text = "Custom Path",
            style = TextStyle(color = Color.Black, textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomPath(color = Color.Blue)
        Text(
            text = "Custom Rectangle Outline",
            style = TextStyle(color = Color.Black, textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomOutline(color = Color.Blue)
        
        
    }
}

@Composable
fun CustomCircle(
    color: Color, modifier: Modifier, minSize: DpSize = DpSize(48.dp, 48.dp)
) {
    Canvas(modifier = modifier.requiredSize(minSize), onDraw = {
        drawCircle(color)
    })

}

@Composable
fun CustomCircleWithGradient(
    centerColor: Color,
    outerColor: Color,
    modifier: Modifier = Modifier,
    minSize: DpSize = DpSize(48.dp, 48.dp)
) {
    Canvas(modifier = modifier.size(minSize), onDraw = {
        drawCircle(brush = Brush.radialGradient(colors = listOf(centerColor, outerColor)))
    })

}

@Composable
fun CustomRectangle(
    color: Color, modifier: Modifier = Modifier, minSize: DpSize = DpSize(48.dp, 48.dp)
) {

    Canvas(modifier = modifier.size(minSize), onDraw = {
        drawRect(color = color)
    })

}

@Composable
fun CustomRoundedRectangle(
    color: Color,
    cornerRadius: CornerRadius,
    modifier: Modifier = Modifier,
    minSize: DpSize = DpSize(48.dp, 48.dp)
) {
    Canvas(modifier = modifier.size(minSize), onDraw = {
        drawRoundRect(
            color = color, cornerRadius = cornerRadius
        )
    })
}

@Composable
fun CustomLine(
    color: Color, modifier: Modifier = Modifier, minSize: DpSize = DpSize(48.dp, 48.dp)
) {
    Canvas(modifier = modifier.size(minSize), onDraw = {
        drawLine(
            color = color,
            start = Offset.Zero,
            end = Offset(size.width, size.width),
            strokeWidth = 2.dp.toPx()
        )
    })
}

@Composable
fun CustomOval(
    color: Color, modifier: Modifier = Modifier, minSize: DpSize = DpSize(48.dp, 48.dp)
) {
    Canvas(modifier = modifier.size(minSize), onDraw = {
        drawOval(
            color = color
        )
    })
}

@Composable
fun CustomArc(
    color: Color, modifier: Modifier = Modifier, minSize: DpSize = DpSize(48.dp, 48.dp)
) {
    Canvas(modifier = modifier.size(minSize), onDraw = {
        drawArc(
            color = color,
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = true,
            style = Stroke(width = 2.dp.toPx())
        )
    })
}

@Composable
fun CustomPath(
    color: Color, modifier: Modifier = Modifier, minSize: DpSize = DpSize(48.dp, 48.dp)
) {
    Canvas(modifier = modifier.size(minSize), onDraw = {
        val path = Path().apply {
            lineTo(size.width, 0f)
            quadraticBezierTo(
                size.width / 2, size.height / 2, size.width, size.height
            )
            lineTo(0f, size.height)
            quadraticBezierTo(size.width / 2, size.height / 2, 0f, 0f)
            close()
        }
        drawPath(color = color, path = path, style = Stroke(width = 2.dp.toPx()))
    })
}

@Composable
fun CustomOutline(
    color: Color,
    modifier: Modifier = Modifier,
    minSize: DpSize = DpSize(48.dp, 48.dp)
) {
    Canvas(modifier = modifier.size(minSize), onDraw = {
        drawOutline(
            outline = Outline.Rectangle(Rect(0f, 0f, size.width, size.height)),
            color = color,
            style = Stroke(width = 2.dp.toPx())
        )
    })

}