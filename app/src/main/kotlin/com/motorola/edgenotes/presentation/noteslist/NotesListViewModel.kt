package com.motorola.edgenotes.presentation.noteslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.motorola.edgenotes.domain.model.Note
import com.motorola.edgenotes.domain.usecase.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class NotesListViewModel @Inject constructor(
    getNotesUseCase: GetNotesUseCase
) : ViewModel() {
    val notes: StateFlow<List<Note>> = getNotesUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
