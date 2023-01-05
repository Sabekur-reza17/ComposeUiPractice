package com.sabekur2017.composeuipractice.uicomponent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DropDownDemo() {
    var expanded by remember {
        mutableStateOf(false)
    }
    val items = listOf("A", "B", "C", "D", "E", "F")
    val disabledValue = "B"
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopCenter)
    ) {
        Text(
            text = items[selectedIndex],
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = {
                    expanded = true
                })
                .background(Color.Gray))
        
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }, modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.Red
            )) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }) {
                     val disableText = if( s== disabledValue){
                         "(Disabled)"
                     }else{
                         ""
                     }
                    Text(text = s+disableText)
                }
            }
        }
    }
}