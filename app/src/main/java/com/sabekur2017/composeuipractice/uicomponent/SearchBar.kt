package com.sabekur2017.composeuipractice.uicomponent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.ui.res.stringResource
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sabekur2017.composeuipractice.R

@Composable
fun MySearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "", onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text(text = stringResource(id = R.string.search_place_holder))
        },
        modifier = modifier.fillMaxWidth().heightIn(min = 56.dp)
    )
}