package com.sorabh.noteapp.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sorabh.noteapp.R
import com.sorabh.noteapp.components.NoteButton
import com.sorabh.noteapp.components.NoteInputField
import com.sorabh.noteapp.data.NoteDataSource
import com.sorabh.noteapp.model.Note
import java.time.format.DateTimeFormatter

@ExperimentalComposeUiApi
@Composable
fun NoteScreen(
    modifier: Modifier = Modifier,
    notes: List<Note>,
    onAddNote: (Note) -> Unit = {},
    onRemoveNote: (Note) -> Unit = {}
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    Column(modifier = modifier.padding(6.dp)) {
        TopAppBar(backgroundColor = Color.LightGray, elevation = 6.dp) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.h6
                )
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "action")
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputField(text = title, label = "Title", onTextChange = { title = it })
            NoteInputField(
                text = description,
                label = "Add a Note",
                onTextChange = { description = it })
            NoteButton(onClick = {
                onAddNote(Note(title = title, description = description))
            })

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .padding(all = 10.dp),
                color = Color.Black,
                thickness = 2.dp
            )
            ShowNotes(notes = notes, onRemoveNote = onRemoveNote)
        }
    }
}

@Composable
fun ShowNotes(modifier: Modifier = Modifier, notes: List<Note>, onRemoveNote: (Note) -> Unit) {
    LazyColumn(modifier = modifier) {
        items(notes) { note ->
            NoteCard(note = note, onRemoveNote = onRemoveNote)
        }
    }
}

@Composable
fun NoteCard(modifier: Modifier = Modifier, note: Note, onRemoveNote: (Note) -> Unit) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(topEnd = 20.dp, topStart = 5.dp, bottomStart = 5.dp, bottomEnd = 5.dp))
            .clickable { onRemoveNote(note) },
        color = Color(201, 233, 247, 255),
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            Text(text = note.title, style = MaterialTheme.typography.h6)
            Text(
                text = note.description,
                style = MaterialTheme.typography.subtitle1,
                fontFamily = FontFamily.SansSerif
            )
            Text(
                text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM yyyy")),
                style = MaterialTheme.typography.caption,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview(showBackground = true)
@ExperimentalComposeUiApi
@Composable
fun NoteScreenPreview() {
    NoteScreen(notes = NoteDataSource().getNotes())
}