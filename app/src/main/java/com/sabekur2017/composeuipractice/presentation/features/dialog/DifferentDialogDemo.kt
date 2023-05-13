package com.sabekur2017.composeuipractice.presentation.features.dialog

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun DifferentDialogDemo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val openSimpleDialog = remember { mutableStateOf(false) }
        val openCustomDialog = remember { mutableStateOf(false) }
        Button(onClick = { openSimpleDialog.value = true }) {
            Text(text = "Simple Alar Dialog")
        }
        SimpleAlertDialog(openSimpleDialog = openSimpleDialog)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { openCustomDialog.value = true }) {
            Text(text = "Simple Alar Dialog")
        }
        CustomDialog(showCustomDialog = openCustomDialog)
        val viewModel: MyViewModel = viewModel()
        val openLoadingDialog by remember {
            viewModel.open
        }

        Spacer(modifier = Modifier.height(16.dp))
        DialogButtonClick(buttonText = "Open loading dialog") {
            viewModel.open.value = true
        }
        if (openLoadingDialog) {
            viewModel.startLoadingThread()
            DialogBoxLoading()
        }

    }
}

@Composable
fun SimpleAlertDialog(openSimpleDialog: MutableState<Boolean>) {

    if (openSimpleDialog.value) {
        AlertDialog(onDismissRequest = { openSimpleDialog.value = false }, title = {
            Text(text = "Alert Dialog")
        }, text = {
            Text(text = "Alert Description")
        }, confirmButton = {
            Button(onClick = { openSimpleDialog.value = false }) {
                Text(text = "Confirm")

            }
        }, dismissButton = {
            Button(onClick = { openSimpleDialog.value = false }) {
                Text(text = "Dismiss")
            }
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDialog(showCustomDialog: MutableState<Boolean>) {
    val txtError = remember { mutableStateOf("") }
    val txtField = remember { mutableStateOf("") }
    if (showCustomDialog.value) {
        Dialog(onDismissRequest = { showCustomDialog.value = false }) {

            Surface(shape = RoundedCornerShape(16.dp), color = Color.White) {
                Box(contentAlignment = Alignment.Center) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "set value",
                                style = TextStyle(
                                    fontSize = 24.sp, fontWeight = FontWeight.Bold
                                ),
                            )
                            Icon(imageVector = Icons.Filled.Cancel,
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp)
                                    .clickable {
                                        showCustomDialog.value = false
                                    })
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        TextField(modifier = Modifier
                            .fillMaxWidth()
                            .border(BorderStroke(width = 2.dp, color = Color.Black)),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Email,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                            },
                            placeholder = { Text(text = "Enter email") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            value = txtField.value,
                            onValueChange = {
                                txtField.value = it.take(10)
                            })
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {

                            },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text(text = "submit")

                        }

                    }
                }

            }

        }
    }

}

@Composable
fun DialogBoxLoading(
    cornerRadius: Dp = 16.dp,
    paddingStart: Dp = 56.dp,
    paddingEnd: Dp = 56.dp,
    paddingTop: Dp = 32.dp,
    paddingBottom: Dp = 32.dp,
    progressIndicatorColor: Color = Color.Green,
    progressIndicatorSize: Dp = 80.dp
) {
    Dialog(onDismissRequest = { }) {

        Surface(
            tonalElevation = 4.dp, shape = RoundedCornerShape(cornerRadius)
        ) {
            Column(
                modifier = Modifier.padding(
                    start = paddingStart, end = paddingEnd, top = paddingTop
                ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProgressIndicatorLoading(
                    progressIndicatorSize = progressIndicatorSize,
                    progressIndicatorColor = progressIndicatorColor
                )
                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Please wait",
                    modifier = Modifier.padding(bottom = paddingBottom),
                    style = TextStyle(color = Color.Black, fontSize = 16.sp)
                )

            }

        }

    }
}

@Composable
fun ProgressIndicatorLoading(progressIndicatorSize: Dp, progressIndicatorColor: Color) {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(animation = keyframes {
            durationMillis = 600
        })
    )

    CircularProgressIndicator(
        progress = 1f, modifier = Modifier
            .size(progressIndicatorSize)
            .rotate(angle)
            .border(
                border = BorderStroke(
                    12.dp, brush = Brush.sweepGradient(
                        listOf(
                            Color.White,
                            progressIndicatorColor.copy(alpha = 0.1f),
                            progressIndicatorColor
                        )
                    )
                ), shape = CircleShape
            ), strokeWidth = 1.dp, color = Color.White

    )
}


@Composable
fun DialogButtonClick(buttonText: String, onButtonClick: () -> Unit) {
    Button(shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(Color.Blue),
        onClick = { onButtonClick() }) {
        Text(text = buttonText, style = TextStyle(fontSize = 16.sp, color = Color.Black))
    }
}
