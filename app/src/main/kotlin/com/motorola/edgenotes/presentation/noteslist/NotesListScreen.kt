package com.motorola.edgenotes.presentation.noteslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.motorola.edgenotes.domain.model.Note

@Composable
fun NotesListScreen(
    onAddNote: () -> Unit,
    onNoteClick: (Int) -> Unit,
    viewModel: NotesListViewModel = hiltViewModel()
) {
    val notes by viewModel.notes.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddNote) {
                Icon(Icons.Default.Add, contentDescription = "Add note")
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(notes) { note ->
                NoteItem(note = note, onClick = { note.id?.let(onNoteClick) })
            }
        }
    }
}

@Composable
private fun NoteItem(note: Note, onClick: () -> Unit) {
    Text(
        text = note.title.ifBlank { note.content.take(30) },
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(16.dp)
    )
}
