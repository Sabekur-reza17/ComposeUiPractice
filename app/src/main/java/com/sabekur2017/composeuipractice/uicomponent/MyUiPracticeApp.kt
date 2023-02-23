package com.sabekur2017.composeuipractice.uicomponent

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sabekur2017.composeuipractice.ui.theme.ComposeUiPracticeTheme

@Composable
fun MyUiPracticeApp() {
    ComposeUiPracticeTheme {
        Scaffold(bottomBar = { SootheBottomNavigation() }) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}