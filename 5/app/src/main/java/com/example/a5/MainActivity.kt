package com.example.a5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a5.data.Dog
import com.example.a5.data.psi
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
                    PasApp()
                }
            }
        }
    }
}

@Composable
fun PasApp() {
    LazyColumn {
        items(psi) { dog ->
            PasItem(
                dog = dog,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun PasItem(
    dog: Dog,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            PasIcon(pasIcon = dog.imageResouceId)
            PasInformacije(imePsa = dog.ime, godinePsa = dog.godine)
        }
    }
}

@Composable
fun PasIcon (
    @DrawableRes pasIcon : Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(pasIcon),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier= modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small)
    )
}

@Composable
fun PasInformacije(
    @StringRes imePsa : Int,
    godinePsa : Int ,
    modifier: Modifier =  Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(imePsa),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.years_old, godinePsa),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
    }
}
