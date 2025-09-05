package com.motorola.edgenotes.presentation.notes.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.motorola.edgenotes.domain.model.Note
import com.motorola.edgenotes.domain.usecase.AddNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val addNote: AddNoteUseCase
) : ViewModel() {
    var title by mutableStateOf("")
        private set
    var content by mutableStateOf("")
        private set

    fun onTitleChange(value: String) {
        title = value
    }

    fun onContentChange(value: String) {
        content = value
    }

    fun saveNote() {
        viewModelScope.launch {
            addNote(
                Note(
                    title = title,
                    content = content,
                    timestamp = System.currentTimeMillis()
                )
            )
        }
    }
}
