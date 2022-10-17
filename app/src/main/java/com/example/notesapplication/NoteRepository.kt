package com.example.notesapplication

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import java.util.concurrent.Flow

class NoteRepository(private val notesDao: NotesDao) {

    // on below line we are creating a variable for our list
    // and we are getting all the notes from our DAO class.
    val allNotes: LiveData<List<Note>> = notesDao.getAllNotes()

    // on below line we are creating an insert method
    // for adding the note to our database.
    suspend fun insert(note: Note) {
        notesDao.insert(note)
    }

    // on below line we are creating a delete method
    // for deleting our note from database.
    suspend fun delete(note: Note){
        notesDao.delete(note)
    }

    // on below line we are creating a update method for
    // updating our note from database.
    suspend fun update(note: Note){
        notesDao.update(note)
    }
}