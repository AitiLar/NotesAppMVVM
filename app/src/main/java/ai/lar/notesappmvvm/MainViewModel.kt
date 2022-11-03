package ai.lar.notesappmvvm

import ai.lar.notesappmvvm.database.room.AppRoomDatabase
import ai.lar.notesappmvvm.database.room.repository.RoomRepository
import ai.lar.notesappmvvm.model.Note
import ai.lar.notesappmvvm.utils.REPOSITORY
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

    val context = application

    fun initDatabase(type: String, onSuccess: ()-> Unit){
        Log.d("checData", "MainViewModel initDatabase: $type")
        when(type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }
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



