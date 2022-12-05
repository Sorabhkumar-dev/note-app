package com.sorabh.noteapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sorabh.noteapp.screen.NoteScreen
import com.sorabh.noteapp.ui.theme.NoteAppTheme
import com.sorabh.noteapp.viewmodels.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                NoteApp()
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun NoteApp(viewModel: NoteViewModel = viewModel()) {
    val context = LocalContext.current
    NoteScreen(notes = viewModel.notes.collectAsState(emptyList()).value,
        onRemoveNote = {
            viewModel.removeNote(it)
            Toast.makeText(context, "${it.title} removed", Toast.LENGTH_LONG).show()
        },
        onAddNote = {
            viewModel.addNote(it)
            Toast.makeText(context, "${it.title} Added", Toast.LENGTH_LONG).show()
        })
}

@ExperimentalComposeUiApi
@Composable
fun MyApp(content: @Composable () -> Unit) {
    NoteAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Preview(showBackground = true)
@ExperimentalComposeUiApi
@Composable
fun NotePreview() {
    NoteApp()
}