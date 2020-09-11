package com.km.nestedrvcompose

import android.util.Log
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreenContent(title: String) {
    val viewState: MutableState<ViewState> = remember(title) { mutableStateOf(Init(title)) }

    MutableStateSample(viewState) {
        Log.d("dbg", "onclick $title ${viewState.value}")
        viewState.value = when (viewState.value) {
            is Init -> Progress(title)
            else -> Init(title)
        }
    }
}

private sealed class ViewState(
    val title: String,
    val subtitle: String,
    val buttonText: String
)

private class Init(title: String) : ViewState(title, "Init", "Start")
private class Progress(title: String) : ViewState(title, "In Progress...", "Cancel")

@Composable
private fun MutableStateSample(viewState: MutableState<ViewState>, onClick: () -> Unit) {
    Row(modifier = Modifier.padding(16.dp)) {
        Column {
            Text(viewState.value.title)
            Text(viewState.value.subtitle)
        }

        OutlinedButton(onClick = { onClick() }, modifier = Modifier.padding(all = 8.dp)) {
            Text(viewState.value.buttonText)
        }
    }
}

