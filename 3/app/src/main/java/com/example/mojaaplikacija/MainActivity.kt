package com.example.mojaaplikacija

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mojaaplikacija.ui.theme.MojaAplikacijaTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MojaAplikacijaTheme {

                Surface {

                    TipTimeLayout()

                }

            }
        }
    }
}



@Composable
fun TipTimeLayout()
{
    Column (modifier = Modifier
        .statusBarsPadding()
        .padding(horizontal = 40.dp)
        .verticalScroll(rememberScrollState())
        .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)

    {

        Text(text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 15.dp, top = 40.dp)
                .align(alignment = Alignment.Start))


        EditNumberField(modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth())

        
        Text(text = stringResource(id = R.string.tip_amount, "0.00$"),
            style = MaterialTheme.typography.displaySmall)
        
        Spacer(modifier = Modifier.height(150.dp))
        
        
        
    }




}


fun calucalteTip(cenaRacuna : Double , tipPostotka : Double = 15.0): String {

    val tip = tipPostotka / 100 * cenaRacuna

    return NumberFormat.getCurrencyInstance().format(tip)


}



@Composable
fun EditNumberField(modifier: Modifier = Modifier)
{

    var inputAmount = mutableSetOf("0")

    TextField(value = inputAmount.value, onValueChange = {}, modifier = modifier)
}