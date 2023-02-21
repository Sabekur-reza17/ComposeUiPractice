package com.sabekur2017.composeuipractice.uicomponent

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sabekur2017.composeuipractice.R


@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawableRes: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(shape = MaterialTheme.shapes.small, modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(192.dp)) {
            Image(
                painter = painterResource(drawableRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionCardPreview() {
    MaterialTheme {
        FavoriteCollectionCard(
            drawableRes = R.drawable.imag_sample,
            text = R.string.txt_nature,
            modifier = Modifier.padding(8.dp)
        )
    }
}