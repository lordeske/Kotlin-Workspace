package com.example.mojaaplikacija

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mojaaplikacija.ui.theme.MojaAplikacijaTheme

class MainActivity : ComponentActivity() {
    val context = this;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MojaAplikacijaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NasaFunkcija(nekiText = "Sneki Pile!!!", context = context )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Cao zdravo $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MojaAplikacijaTheme {
        Greeting("Android")
    }
}


@Composable
fun NasaFunkcija(nekiText : String, context : Context)
{
    Column {
        Greeting(name = nekiText)
        Button(onClick = {
            Toast.makeText(context,"Volim te secerlemice, mi se volimo!!!",Toast.LENGTH_SHORT).show()
        }) {

            Text(text = context.getString(R.string.btn_click))
            
        }
    }
}

