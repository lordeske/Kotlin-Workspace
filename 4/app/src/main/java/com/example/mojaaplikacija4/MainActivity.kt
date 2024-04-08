package com.example.mojaaplikacija4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mojaaplikacija4.ui.theme.MojaAplikacija4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MojaAplikacija4Theme {
                // A surface container using the 'background' color from the theme

                }
            }
        }
    }







@Composable
fun ListApp(){

}

@Composable
fun ResursKartica( resurstModel : ResursModell , modifier: Modifier = Modifier){

    Card (modifier= modifier)
    {
        Column {
            Image(painter = painterResource(id = resurstModel.imageResurs), contentDescription = stringResource(
                id = resurstModel.stringResursId
            ), modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
                contentScale = ContentScale.Crop)


            Text(text = LocalContext.current.getString(resurstModel.stringResursId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall)
        }
    }

}
