package com.sabekur2017.composeuipractice.presentation.features.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun CardDemo() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { }, elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(buildAnnotatedString {
                append ("This is")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W600,
                        color = Color.Blue
                    )
                ) {
                    append("Jetpack compose card")
                }
            })
            Text(text = buildAnnotatedString {
                append("simple compose card")
                withStyle(style = SpanStyle(fontWeight = FontWeight.W600)){
                    append("card example")
                }
            })

        }
    }
}