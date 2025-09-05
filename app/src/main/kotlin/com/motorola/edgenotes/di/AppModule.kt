package com.motorola.edgenotes.di

import android.app.Application
import androidx.room.Room
import com.motorola.edgenotes.data.local.EdgeNotesDatabase
import com.motorola.edgenotes.data.local.NoteDao
import com.motorola.edgenotes.data.repository.NoteRepositoryImpl
import com.motorola.edgenotes.domain.repository.NoteRepository
import com.motorola.edgenotes.domain.usecase.AddNoteUseCase
import com.motorola.edgenotes.domain.usecase.DeleteNoteUseCase
import com.motorola.edgenotes.domain.usecase.GetNoteUseCase
import com.motorola.edgenotes.domain.usecase.GetNotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): EdgeNotesDatabase =
        Room.databaseBuilder(app, EdgeNotesDatabase::class.java, "edge_notes.db").build()

    @Provides
    fun provideNoteDao(db: EdgeNotesDatabase): NoteDao = db.noteDao()

    @Provides
    @Singleton
    fun provideNoteRepository(dao: NoteDao): NoteRepository = NoteRepositoryImpl(dao)

    @Provides
    fun provideGetNotesUseCase(repo: NoteRepository) = GetNotesUseCase(repo)

    @Provides
    fun provideGetNoteUseCase(repo: NoteRepository) = GetNoteUseCase(repo)

    @Provides
    fun provideAddNoteUseCase(repo: NoteRepository) = AddNoteUseCase(repo)

    @Provides
    fun provideDeleteNoteUseCase(repo: NoteRepository) = DeleteNoteUseCase(repo)
}
