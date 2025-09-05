package com.motorola.edgenotes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1)
abstract class EdgeNotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
