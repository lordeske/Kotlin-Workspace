package com.example.a5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a5.data.Dog
import com.example.a5.ui.theme._5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}




@Composable
fun PasItem(
    dog : Dog,
    modifier: Modifier = Modifier
)
{

    Card (
        modifier = modifier
    )
    {
        Row (modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_small)))

        {
            PasIcon(pasIcon = dog.imageResouceId)
        }

    }







}






@Composable
fun PasIcon (
    @DrawableRes pasIcon : Int,
    modifier: Modifier = Modifier
)
{
    Image(painter = painterResource(pasIcon),
        contentDescription =null ,
        contentScale = ContentScale.Crop,
        modifier= modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small))


}



@Composable
fun PasInformacije(
    @StringRes imePsa : Int,
    
)


