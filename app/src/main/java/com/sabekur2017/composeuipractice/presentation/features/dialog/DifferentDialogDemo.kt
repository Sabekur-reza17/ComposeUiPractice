package com.sabekur2017.composeuipractice.presentation.features.dialog


import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun DifferentDialogDemo() {
    Column(
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedButtonDemo()
        Spacer(modifier = Modifier.height(16.dp))
        OutlineButtonDemo()
        Spacer(modifier = Modifier.height(16.dp))
        FilledTonalButtonDemo()
        Spacer(modifier = Modifier.height(16.dp))
        ButtonWithIconDemo()
        Spacer(modifier = Modifier.height(16.dp))
        IconToggleButtonDemo()
        Spacer(modifier = Modifier.height(16.dp))
        TextButtonDemo()
    }

}

@Composable
fun ElevatedButtonDemo() {
    ElevatedButton(onClick = {

    }) {
        Text(text = "ElevatedButton ", style = MaterialTheme.typography.labelLarge)

    }
}

@Composable
fun OutlineButtonDemo() {
    OutlinedButton(onClick = { }) {
        Text(text = "OutlinedButton", style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
fun FilledTonalButtonDemo() {
    FilledTonalButton(onClick = { }) {
        Text(text = "FilledTonalButton")
    }
}

@Composable
fun ButtonWithIconDemo() {
    Button(onClick = { }) {
        Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
        Text(text = "Button with icon", style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
fun IconToggleButtonDemo() {
    var checked by remember {
        mutableStateOf(false)
    }
    IconToggleButton(checked = checked, onCheckedChange = {
        checked = it
    }) {
        val tint by animateColorAsState(targetValue = if (checked) Color.Blue else Color.Green)
        Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
    }
}

@Composable
fun TextButtonDemo(){
    TextButton(onClick = { }) {
        Text(text = "Simple Text Button")
    }
}