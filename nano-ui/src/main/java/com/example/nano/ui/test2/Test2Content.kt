package com.example.nano.ui.test2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Test2Content() {
    Surface(
        modifier = Modifier
            .safeContentPadding()
            .fillMaxSize()
    ) {
        Column {
            Text("Test2Content")
            Text("★　☆　★ sabun")
        }
    }
}

@Preview
@Composable
fun Test2ContentPreview() {
    Test2Content()
}