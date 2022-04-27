package com.example.room.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.data.Data
import com.example.room.data.DiaryRepository
import kotlinx.coroutines.launch

class MyViiewModel(private val repo:DiaryRepository): ViewModel(){
    var getrepo:LiveData<List<Data>> = repo.daoValue//return a livedata of list of data class"entitty"
     var text by mutableStateOf("")
    var time by mutableStateOf("")
    var tittle by mutableStateOf("")
    fun  insertOrUpdate(){
        val text= text
        val time= time
        val tittle= tittle
 insert(Data(title = text,id=0,time=time,diaryText = tittle))


    }
    fun deleteAll(){
        delete()
    }
 fun deleteSpecificData(title:String){
     deleteSpecific(title)
 }


    fun delete() {
        viewModelScope.launch {
            repo.delete()
        }
    }
        fun insert(data:Data){
            viewModelScope.launch{
                repo.insert(data)
            }
        }

        fun update(data: Data){
            viewModelScope.launch {
                repo.update(data)
            }
        }
  fun deleteSpecific(title:String){
      viewModelScope.launch {
          repo.deleteSpecific(title)
      }
  }


}