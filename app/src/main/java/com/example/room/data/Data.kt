package com.example.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Data")
data class Data(
    @ColumnInfo(name="title")
    val title:String,
    @ColumnInfo(name="diaryText")
    val diaryText:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="time")
    val time:String,

)
