package plat.lab6.hernandez_maldonado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusTargetModifierNode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import plat.lab6.hernandez_maldonado.ui.theme.LAB6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LAB6Theme {
                Contador()
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
        mutableIntStateOf(0)
    }
    var incrementos by remember {
        mutableIntStateOf(0)
    }
    var decrementos by remember {
        mutableIntStateOf(0)
    }
    var max by remember {
        mutableIntStateOf(0)
    }
    var min by remember {
        mutableIntStateOf(0)
    }
    val historial = remember {
        mutableListOf<Movimientos>()
    }
    val totalCambios = incrementos + decrementos

    Surface (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text (
                modifier = Modifier,
                text = "Valeria Hernández",
                style = MaterialTheme.typography.headlineLarge

            )

            Spacer (
                modifier = Modifier.height(30.dp)
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    10.dp,
                    Alignment.CenterHorizontally
                )
            ) {
                FilledIconButton(
                    onClick = {
                        contador--
                        decrementos++

                        historial.add(
                            Movimientos(
                                valor = contador,
                                esIncremento = false
                            )
                        )
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "Decremento"
                    )
                }

                Text (
                    text = "$contador",
                    style = MaterialTheme.typography.displayLarge
                )

                FilledIconButton(
                    onClick = {
                        contador++
                        incrementos++

                        historial.add(
                            Movimientos(
                                valor = contador,
                                esIncremento = true
                            )
                        )
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Incrementos"
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 15.dp)
            )

            Column (
                modifier = Modifier.padding(horizontal = 22.dp)
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text (
                        text = "Total incrementos:",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Text (
                        text = "$incrementos",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text (
                        text = "Total decrementos:",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Text (
                        text = "$decrementos",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text (
                        text = "Valor máximo:",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Text (
                        text = "$max",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text (
                        text = "Valor mínimo:",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Text (
                        text = "$min",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text (
                        text = "Total cambios:",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Text (
                        text = "$totalCambios",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }

                Text (
                    text = "Historial:",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium
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