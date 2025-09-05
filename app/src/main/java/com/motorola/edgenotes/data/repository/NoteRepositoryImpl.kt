package com.motorola.edgenotes.data.repository

import com.motorola.edgenotes.data.local.NoteDao
import com.motorola.edgenotes.data.local.NoteEntity
import com.motorola.edgenotes.domain.model.Note
import com.motorola.edgenotes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val dao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> =
        dao.getNotes().map { entities ->
            entities.map { it.toNote() }
        }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note.toEntity())
    }

    override suspend fun deleteNote(id: Long) {
        dao.deleteNote(id)
    }
}

private fun NoteEntity.toNote() = Note(
    id = id,
    title = title,
    content = content,
    timestamp = timestamp
)

private fun Note.toEntity() = NoteEntity(
    id = id,
    title = title,
    content = content,
    timestamp = timestamp
)
