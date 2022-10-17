package com.example.notesapplication

import androidx.lifecycle.LiveData
import androidx.room.*

// annotation for dao class.
@Dao
interface NotesDao {

    // below is the insert method for
    // adding a new entry to our database.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note :Note)

    // below is the delete method
    // for deleting our note.
    @Delete
    suspend fun delete(note: Note)

    @Query("Select * from notesTable order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>

    // below method is use to update the note.
    @Update
    suspend fun update(note: Note)
}