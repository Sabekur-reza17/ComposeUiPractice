package com.sabekur2017.composeuipractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.sabekur2017.composeuipractice.internals.columColor
import  com.sabekur2017.composeuipractice.internals.*
import com.sabekur2017.composeuipractice.navigation.Navigation
import com.sabekur2017.composeuipractice.uicomponent.DropDownDemo
import com.sabekur2017.composeuipractice.uicomponent.ModelDrawerSample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           //  MainContent()
            ModelDrawerSample()
        }
    }
}

@Composable
fun MainContent(){
    val scrollState= rememberScrollState()
    LaunchedEffect(Unit){scrollState.animateScrollTo(10000)}
    Column(modifier = Modifier
        .background(columColor)
        .fillMaxSize()
        .verticalScroll(scrollState)) {
        repeat(100){  counter->
            Text(
                text = "Counter : $counter",
                fontSize = textFontSize,
                color = textColor,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(normalRadius))
                    .background(backgroundColor)
                    .padding(normalElevation)
                    .background(
                        if (counter % 2 == 0) evenColor
                        else oddColor
                    )
                    .padding(size25dp)
            )
        }

    }
}
@Preview
@Composable
fun ComposablePreview(){
   // MainContent()
    Navigation()
}
