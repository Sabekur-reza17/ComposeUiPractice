package com.sabekur2017.composeuipractice.uicomponent

import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun AlertDialogExample() {
    // test
    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(false) }
            Button(onClick = {
                openDialog.value = true
            }) {
                Text(text = "click me")
            }
            if (openDialog.value) {
                AlertDialog(onDismissRequest = {
                    openDialog.value = false
                },
                    title = {
                        Text(text = "Dialog title")
                    },
                    text = {
                        Text(text = "Here is the text")
                    },
                    confirmButton = {
                        Button(onClick = {
                            openDialog.value = false
                        }) {
                            Text(text = "Here is the confirm button")
                        }
                    },
                    dismissButton = {
                        Button(onClick = { openDialog.value = false })
                        {
                            Text(text = "Here is the dismiss button")
                        }
                    }
                )
            }
        }
    }
}