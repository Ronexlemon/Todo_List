package com.example.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.room.data.DiaryRepository
import com.example.room.viewmodel.MyViiewModel

class SubViewModelFactory(private val repository: DiaryRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MyViiewModel::class.java)){

            return MyViiewModel(repository) as T}
        throw IllegalArgumentException("Unknown class")
    }


}