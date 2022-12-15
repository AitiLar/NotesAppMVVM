package ai.lar.notesappmvvm.database

import ai.lar.notesappmvvm.model.Note
import androidx.lifecycle.LiveData

interface DatabaseRepository {
    val readAll: LiveData<List<Note>>

    suspend fun create(note: Note, onSuccess: () -> Unit)

    suspend fun update(note: Note, onSuccess: () -> Unit)

    suspend fun delete(note: Note, onSuccess: () -> Unit)

    fun signOut() {}

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {}
}