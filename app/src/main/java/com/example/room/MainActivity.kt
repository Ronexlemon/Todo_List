package com.example.room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.room.data.DiaryDao
import com.example.room.data.DiaryRepository
import com.example.room.database.DiaryDatabase
import com.example.room.ui.theme.RoomTheme
import com.example.room.viewmodel.MyViiewModel

class MainActivity : ComponentActivity() {
    private  lateinit var viewmodel:MyViiewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomTheme {
                /*
                * calling the database
                * */
                val dao :DiaryDao = DiaryDatabase.getInstance(application).dao
                val repo  = DiaryRepository(dao)
                val factory = SubViewModelFactory(repo)
                viewmodel= ViewModelProvider(this,factory).get(MyViiewModel::class.java)
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0x4A652B)
                ) {
                    //MainScreen(viewmodel =viewmodel )
                    NavigationGraph(navcontroller =navController , viewmodel =viewmodel )
                }
            }
        }
    }
}

