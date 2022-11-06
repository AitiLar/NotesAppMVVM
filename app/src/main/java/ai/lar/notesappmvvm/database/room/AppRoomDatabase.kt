package ai.lar.notesappmvvm.database.room

import ai.lar.notesappmvvm.database.room.dao.NoteRoomDao
import ai.lar.notesappmvvm.model.Note
import ai.lar.notesappmvvm.utils.Constants.Keys.NOTE_DATABASE
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase(){

    abstract fun getRoomDao(): NoteRoomDao

    companion object{

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context): AppRoomDatabase{
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    NOTE_DATABASE
                ).build()
                INSTANCE as AppRoomDatabase

            } else INSTANCE as AppRoomDatabase
        }
    }
}