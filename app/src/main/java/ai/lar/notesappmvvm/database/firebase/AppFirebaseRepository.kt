package ai.lar.notesappmvvm.database.firebase

import ai.lar.notesappmvvm.database.DatabaseRepository
import ai.lar.notesappmvvm.model.Note
import ai.lar.notesappmvvm.utils.LOGIN
import ai.lar.notesappmvvm.utils.PASSWORD
import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth

class AppFirebaseRepository: DatabaseRepository{
    private val mAuth = FirebaseAuth.getInstance()
    override val readAll: LiveData<List<Note>>
        get() = TODO("Not yet implemented")

    override suspend fun create(note: Note, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun update(note: Note, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun signOut() {
        mAuth.signOut()
    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        mAuth.signInWithEmailAndPassword(LOGIN, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                mAuth.createUserWithEmailAndPassword(LOGIN, PASSWORD)
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener { onFail(it.message.toString()) }
            }
    }
}