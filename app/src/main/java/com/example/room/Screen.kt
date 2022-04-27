package com.example.room

sealed class Screen(val route:String){
    object DataScreen:Screen(route="dataItem")
    object DataDisplay:Screen(route="datadisplay")
}
