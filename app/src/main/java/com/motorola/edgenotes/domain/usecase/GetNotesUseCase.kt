package com.motorola.edgenotes.domain.usecase

import com.motorola.edgenotes.domain.model.Note
import com.motorola.edgenotes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke(): Flow<List<Note>> = repository.getNotes()
}
