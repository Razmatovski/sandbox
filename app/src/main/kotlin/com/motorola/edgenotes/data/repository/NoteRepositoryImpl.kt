package com.motorola.edgenotes.data.repository

import com.motorola.edgenotes.data.local.NoteDao
import com.motorola.edgenotes.data.local.NoteEntity
import com.motorola.edgenotes.domain.model.Note
import com.motorola.edgenotes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(private val dao: NoteDao) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> =
        dao.getNotes().map { entities -> entities.map { it.toDomain() } }

    override suspend fun getNote(id: Int): Note? = dao.getNote(id)?.toDomain()

    override suspend fun insertNote(note: Note) {
        dao.insert(note.toEntity())
    }

    override suspend fun deleteNote(note: Note) {
        note.id?.let { dao.delete(NoteEntity(it, note.title, note.content, note.timestamp)) }
    }
}

private fun NoteEntity.toDomain(): Note = Note(id, title, content, timestamp)

private fun Note.toEntity(): NoteEntity =
    if (id != null) NoteEntity(id, title, content, timestamp)
    else NoteEntity(title = title, content = content, timestamp = timestamp)
