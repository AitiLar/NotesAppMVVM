package ai.lar.notesappmvvm.database.room.repository

import ai.lar.notesappmvvm.database.DatabaseRepository
import ai.lar.notesappmvvm.database.room.dao.NoteRoomDao
import ai.lar.notesappmvvm.model.Note
import androidx.lifecycle.LiveData

class RoomRepository(private val noteRoomDao: NoteRoomDao) : DatabaseRepository {
    override val readAll: LiveData<List<Note>>
        get() = noteRoomDao.getAllNotes()

    override suspend fun create(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.addNote(note = note)
        onSuccess()
    }

    override suspend fun update(note: Note, onSuccess: () -> Unit) {
       noteRoomDao.updateNote(note = note)
        onSuccess()
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.deleteNote(note = note)
        onSuccess()
    }
}