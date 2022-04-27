package com.example.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room.data.Data
import com.example.room.data.DiaryDao

@Database(entities = [Data::class],version = 1,exportSchema = false)
abstract class DiaryDatabase:RoomDatabase() {
    abstract val dao:DiaryDao
    companion object{
        @Volatile
        private var INSTANCE:DiaryDatabase?=null
        fun getInstance(context:Context):DiaryDatabase{
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DiaryDatabase::class.java,
                        "diary_database"
                    )
                        .allowMainThreadQueries()//fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }


}