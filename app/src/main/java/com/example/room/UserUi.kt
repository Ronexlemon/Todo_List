package com.example.room

import android.content.res.Resources
import android.view.RoundedCorner
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.navigation.NavHostController
import com.example.room.data.Data
import com.example.room.viewmodel.MyViiewModel

@Composable
fun MainScreen(viewmodel:MyViiewModel,navcontroller: NavHostController){

    Scaffold(
        topBar = {
            TopBarr()
        },
        content = {
GetUserData(viewmodel = viewmodel,navcontroller = navcontroller)
        },

    )


}

@Composable
fun TopBarr(modifier: Modifier =Modifier){
    TopAppBar(title = {Text(text="ToDo",
        style = TextStyle(fontFamily = FontFamily.Cursive),
        fontWeight = FontWeight(20),fontSize = 16.sp,textDecoration = TextDecoration.LineThrough)},
        modifier=modifier.background(color= Color.DarkGray))


}


@Composable
fun GetUserData(modifier:Modifier=Modifier,viewmodel:MyViiewModel,navcontroller:NavHostController){
    Column(modifier= modifier
        .fillMaxSize()
        .background(color =Color.Red )){
        OutlinedTextField(modifier=modifier.padding(16.dp).fillMaxWidth(),value =viewmodel.tittle , onValueChange ={viewmodel.tittle=it} ,label = {Text(text="title")},shape =RoundedCornerShape(size=10.dp))

        Column(modifier = modifier
            .fillMaxWidth()
            .height(250.dp)){
            OutlinedTextField(
                value = viewmodel.text,
                onValueChange = { viewmodel.text = it },
                label = { Text("Todo") }
                ,modifier= modifier
                    .fillMaxWidth()
                    .height(100.dp).padding(16.dp),shape =RoundedCornerShape(size=10.dp))

            //Spacer(modifier=modifier.height(0.dp))

            OutlinedTextField(modifier=modifier.padding(16.dp).fillMaxWidth(),shape =RoundedCornerShape(size=10.dp),value =viewmodel.time , onValueChange ={viewmodel.time=it} ,label = {Text(text="venue")})
            Row(horizontalArrangement = Arrangement.SpaceBetween ,modifier=modifier.fillMaxWidth().height(height = 100.dp)){
                Button(onClick = { viewmodel.insertOrUpdate()},
                    modifier
                        .padding(8.dp)
                        .background(color = Color.DarkGray),
                    shape = RoundedCornerShape(size=10.dp)) {
                    Text(text="Add")
                }
                Button(onClick = {navcontroller.navigate(Screen.DataDisplay.route) },
                    modifier
                        .padding(8.dp)
                        .background(color = Color.DarkGray),
                    shape = RoundedCornerShape(size=10.dp)) {
                    Text(text="Todo")
                }
            }




        }
        Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter= painterResource(id = R.drawable.todo),contentDescription = null,modifier.fillMaxWidth().height(200.dp))

           Row(horizontalArrangement = Arrangement.SpaceEvenly){
               Text(text="What?",
                   style = TextStyle(fontFamily = FontFamily.Cursive),
                   fontWeight = FontWeight(20),fontSize = 16.sp,textDecoration = TextDecoration.LineThrough)
               Text(text="When?",
                   style = TextStyle(fontFamily = FontFamily.Cursive),
                   fontWeight = FontWeight(20),fontSize = 16.sp,textDecoration = TextDecoration.LineThrough)

               Text(text="Where?",
                   style = TextStyle(fontFamily = FontFamily.Cursive),
                   fontWeight = FontWeight(20),fontSize = 16.sp,textDecoration = TextDecoration.LineThrough) }



        }
        }





   // DisplayList(viewmodel = viewmodel)
}
@Composable
fun DisplayList(viewmodel: MyViiewModel){
    val list by  viewmodel.getrepo.observeAsState(initial = emptyList())//observing the state of the database

    LazyColumn{
        items(list){item->
            ItemList(item = item,viewmodel = viewmodel)

        }
    }

}

@Composable
fun ItemList(item:Data,modifier:Modifier=Modifier,viewmodel: MyViiewModel) {


            Card(elevation = 15.dp,modifier= modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
                .background(color = Color.Red),shape= RoundedCornerShape(15.dp)
            ){
                Row(modifier=modifier.fillMaxSize(),horizontalArrangement = Arrangement.SpaceBetween){

                    Column(verticalArrangement = Arrangement.SpaceEvenly){

                        Text(text=item.diaryText)
                        Text(text=item.time)
                        Text(text=item.title)
                    }
                    Text(text="X",
                        modifier
                            .align(Alignment.Top)
                            .padding(end = 8.dp)
                            .clickable { viewmodel.deleteSpecific(item.title) },style= TextStyle(fontSize = 16.sp,fontWeight = FontWeight.Black))//clickable event to delete a single data item based on the tittle
                }


            }


}



@Preview(showBackground = true)
@Composable
fun DefaultView(){

}