package plat.lab6.hernandez_maldonado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import plat.lab6.hernandez_maldonado.ui.theme.LAB6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LAB6Theme {

            }
        }
    }
}

data class Movimientos (
    val valor: Int,
    val esIncremento: Boolean
)

@Composable
fun Contador(
    modifier: Modifier = Modifier
) {
    var contador by remember {
        mutableStateOf(0)
    }
    var incrementos by remember {
        mutableStateOf(0)
    }
    var decrementos by remember {
        mutableStateOf(0)
    }
    var max by remember {
        mutableStateOf(0)
    }
    var min by remember {
        mutableStateOf(0)
    }
    val historial by remember {
        mutableListOf<Movimientos>()
    }

    Surface (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text (
                text = "Valeria Hernández Maldonado",

            )

            Row (
                modifier = Modifier
            ) {
                FilledIconButton (
                    onClick = {},
                    modifier = Modifier
                ) {

                }
                Text (
                    text = "$contador"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContadorPreview()
{
    Contador()
}