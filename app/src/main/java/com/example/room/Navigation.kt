package com.example.room

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.room.viewmodel.MyViiewModel

@Composable
fun NavigationGraph(navcontroller:NavHostController,viewmodel:MyViiewModel){

    NavHost(navController = navcontroller,startDestination = Screen.DataScreen.route){
        composable(route=Screen.DataScreen.route){
            MainScreen(viewmodel = viewmodel,navcontroller = navcontroller)
        }
        composable(route=Screen.DataDisplay.route){
            DisplayData(viewmodel = viewmodel)
        }
    }
}