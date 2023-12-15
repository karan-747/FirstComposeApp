package com.testers.unique.composedemo

import android.content.Context
import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.testers.unique.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            sayHello()
        }
    }
}

/**/


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun sayHello() {

    var name by remember {
        mutableStateOf("")
    }
    var names by remember {
        mutableStateOf(mutableListOf<String>())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { text ->
                    name = text
                },
                modifier =  Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                names.add(name)
                name = ""
            }) {
                Text(text = "Add")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn {
            items(names) { currentName ->
                Text(
                    text = currentName,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(5.dp)
                )
                Divider()

            }
        }
    }


    /*var count by remember {
        mutableStateOf(0)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = count.toString(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
            )

        Button(onClick = {
            count++
        }) {
            Text(
                text = "Increment",
            )
        }

    }*/
    /* LazyColumn(
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.SpaceEvenly,
         modifier = Modifier.background(Color.Black)
     )
     {
         items(50) {
             Row(
                 verticalAlignment = Alignment.CenterVertically,
                 horizontalArrangement = Arrangement.Center
             ) {
                 Text(
                     text = it.toString(),
                     fontSize = 24.sp,
                     color = Color.White,
                     modifier = Modifier.background(Color.Black)
                         .fillMaxHeight()


                 )
                 Image(
                     painter = painterResource(id = R.drawable.ic_launcher_foreground),
                     contentDescription = null,
                     modifier = Modifier
                         .fillMaxWidth()
                         .background(Color.Black)
                         .padding(10.dp)
                 )
             }
         }
     }*/
}

@Preview(showBackground = true, widthDp = 400, heightDp = 850)
@Composable
fun GreetingPreview() {
    sayHello()
}