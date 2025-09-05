package com.motorola.edgenotes.presentation.notedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.motorola.edgenotes.domain.model.Note
import com.motorola.edgenotes.domain.usecase.AddNoteUseCase
import com.motorola.edgenotes.domain.usecase.GetNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val getNoteUseCase: GetNoteUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var title by mutableStateOf("")
        private set
    var content by mutableStateOf("")
        private set
    private var currentNoteId: Int? = null

    init {
        val id = savedStateHandle.get<Int>("noteId")
        if (id != null) {
            viewModelScope.launch {
                getNoteUseCase(id)?.let { note ->
                    currentNoteId = note.id
                    title = note.title
                    content = note.content
                }
            }
        }
    }

    fun onTitleChange(newTitle: String) {
        title = newTitle
    }

    fun onContentChange(newContent: String) {
        content = newContent
    }

    fun saveNote() {
        viewModelScope.launch {
            val note = Note(
                id = currentNoteId,
                title = title,
                content = content,
                timestamp = System.currentTimeMillis()
            )
            addNoteUseCase(note)
        }
    }
}
