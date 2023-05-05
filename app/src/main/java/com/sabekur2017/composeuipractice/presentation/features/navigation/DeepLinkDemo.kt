package com.sabekur2017.composeuipractice.presentation.features.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink

@Composable
fun DeepLinkDemo() {

    val navController = rememberNavController()
    val uri = "https://developer.android.com"
    NavHost(navController = navController, startDestination = "deeplinkdemo", builder = {
        composable(route = "deeplinkdemo", deepLinks = listOf(
            navDeepLink { uriPattern = "$uri/{page}" }
        )) { navBackStackEntry ->
            val page = navBackStackEntry.arguments?.getString("page")
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "$page")

            }
        }
    })

}