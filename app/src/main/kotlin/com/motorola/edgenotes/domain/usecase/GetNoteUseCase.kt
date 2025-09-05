package com.motorola.edgenotes.domain.usecase

import com.motorola.edgenotes.domain.model.Note
import com.motorola.edgenotes.domain.repository.NoteRepository

class GetNoteUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(id: Int): Note? = repository.getNote(id)
}
