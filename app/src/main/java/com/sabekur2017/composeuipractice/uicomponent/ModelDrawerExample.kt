package com.sabekur2017.composeuipractice.uicomponent

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ModelDrawerSample(){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope  = rememberCoroutineScope()
    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column {
                Text(text = "Text in drawer")
                Button(onClick = {
                    scope.launch {
                        drawerState.close()
                    }
                }) {
                    Text(text = "close drawer")
                }
            }
        },
        content = {
            Column {
                Text(text = "Text in body context")
                Button(onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                }) {
                    Text(text = "Click to open")
                }
            }
        }
    )
}