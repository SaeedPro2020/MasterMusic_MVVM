package com.example.mastermusic.model.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MusicEntityDb::class], version = 1, exportSchema = false)
abstract class MusicDatabase : RoomDatabase() {

    abstract fun musicDao(): MusicDao

    companion object {
        @Volatile
        private var INSTANCE: MusicDatabase? = null

        fun getDatabase(context: Context): MusicDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MusicDatabase::class.java,
                        "musics.db",
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }

}
