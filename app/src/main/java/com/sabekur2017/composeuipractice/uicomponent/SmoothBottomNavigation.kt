package com.sabekur2017.composeuipractice.uicomponent

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.sabekur2017.composeuipractice.R

@Composable
fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background, modifier = modifier
    ) {
        BottomNavigationItem(icon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = null
            )
        }, label = {
            Text(
                text = stringResource(id = R.string.bottom_navigation_home)
            )
        }, selected = true, onClick = { })
        BottomNavigationItem(icon = {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null
            )
        }, label = {
            Text(text = stringResource(id = R.string.bottom_navigation_profile))
        }, selected = false, onClick = { })
    }
}