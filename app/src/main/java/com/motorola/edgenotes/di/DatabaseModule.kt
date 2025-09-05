package com.motorola.edgenotes.di

import android.content.Context
import androidx.room.Room
import com.motorola.edgenotes.data.local.NoteDatabase
import com.motorola.edgenotes.data.repository.NoteRepositoryImpl
import com.motorola.edgenotes.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(context, NoteDatabase::class.java, "notes.db").build()

    @Provides
    @Singleton
    fun provideRepository(db: NoteDatabase): NoteRepository = NoteRepositoryImpl(db.noteDao())
}
