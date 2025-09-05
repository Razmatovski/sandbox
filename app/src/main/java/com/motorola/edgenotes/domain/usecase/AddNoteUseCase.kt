package com.motorola.edgenotes.domain.usecase

import com.motorola.edgenotes.domain.model.Note
import com.motorola.edgenotes.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.insertNote(note)
    }
}
