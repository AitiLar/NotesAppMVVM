package ai.lar.notesappmvvm

import ai.lar.notesappmvvm.model.Note
import ai.lar.notesappmvvm.utils.TYPE_FIREBASE
import ai.lar.notesappmvvm.utils.TYPE_ROOM
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel (application: Application) :AndroidViewModel(application) {

    val readTest: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }

    val dbType: MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM)
    }

    init {
        readTest.value =
            when(dbType.value){
                TYPE_ROOM -> {
                    listOf<Note>(
                        Note(title = "Note 1", subtitle = "subtitle for note 1"),
                        Note(title = "Note 2", subtitle = "subtitle for note 2"),
                        Note(title = "Note 3", subtitle = "subtitle for note 3"),
                        Note(title = "Note 4", subtitle = "subtitle for note 14")
                    )
                }
                TYPE_FIREBASE -> listOf()
                else -> listOf()
            }
    }

    fun initDatabase(type: String){
        dbType.value = type
        Log.d("checData", "MainViewModel initDatabase: $type")
    }
}

class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application = application) as T
        }
        throw IllegalAccessException("Unknow ViewModel Class")
    }


}



