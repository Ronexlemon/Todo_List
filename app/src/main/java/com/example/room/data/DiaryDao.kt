package com.example.room.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface DiaryDao {
    @Query("SELECT * FROM Data")
     fun selectAll():LiveData<List<Data>>
    @Insert
  suspend   fun insert(data:Data)
  @Update
  suspend fun update(data:Data)

    @Query("DELETE FROM Data")
   suspend fun deleteAll()
   @Query("DELETE FROM Data WHERE title= :tittle")
   suspend fun deleteSpecific(tittle:String)


}