package com.sabekur2017.composeuipractice.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sabekur2017.composeuipractice.internals.size50dp
import com.sabekur2017.composeuipractice.internals.size8dp

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
         HomeScreen(navController = navController)
        }
        composable(
            route=Screen.DetailScreen.route +"/{name}",
            arguments = listOf(
                navArgument("name"){
                    type= NavType.StringType
                    defaultValue="sabekur"
                    nullable=true
                }
            )
        ){ entry->
            DetailScreen(name =entry.arguments?.getString("name") )
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    var text by remember{
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = size50dp)
    ) {
        TextField(value = text, onValueChange ={
            text=it
        },
        modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(size8dp))
        Button(onClick = {
                         navController.navigate(Screen.DetailScreen.withArgs(text))
         },
        modifier = Modifier.align(Alignment.End)) {
            Text(text = "To Detail Screen")

        }
    }
}

@Composable
fun DetailScreen(name:String?){
  Box(contentAlignment = Alignment.Center,
  modifier = Modifier.fillMaxSize()) {
      Text(text = "hello ,$name")

  }
}