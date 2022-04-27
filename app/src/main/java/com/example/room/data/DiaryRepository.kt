package com.example.room.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DiaryRepository(private val dao: DiaryDao) {
    val daoValue:LiveData<List<Data>> = dao.selectAll()

    suspend fun insert(data: Data){
        dao.insert(data)
    }
suspend fun update(data: Data){
    dao.update(data)
}
suspend fun  delete(){
    dao.deleteAll()
}
    suspend fun  deleteSpecific(title:String){
        dao.deleteSpecific(title)
    }




}