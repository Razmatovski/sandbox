package com.motorola.edgenotes.presentation.notes.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NoteDetailScreen(
    viewModel: NoteDetailViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = viewModel.title,
            onValueChange = viewModel::onTitleChange,
            placeholder = { Text("Title") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = viewModel.content,
            onValueChange = viewModel::onContentChange,
            placeholder = { Text("Content") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = viewModel::saveNote) {
            Text("Save")
        }
    }
}
