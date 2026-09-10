package plat.lab6.hernandez_maldonado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

data class Movimiento (
    val valor: Int,
    val esIncremento: Boolean
)

@Composable
fun Estadistica(
    nombre: String,
    valor: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = nombre,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "$valor",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun ItemHistorial(
    movimiento: Movimiento
) {
    val colorMovimiento = if (movimiento.esIncremento) {
        Color(0xFF16852B)
    } else {
        Color(0xFFC6281B)
    }

    Box (
        modifier = Modifier
            .height(45.dp)
            .background(
                color = colorMovimiento,
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "${movimiento.valor}",
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

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
        mutableStateListOf<Movimiento>()
    }
    val totalCambios = incrementos + decrementos

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
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

                        if (contador < min) {
                            min = contador
                        }

                        historial.add(
                            Movimiento(
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

                        if (contador > max) {
                            max = contador
                        }

                        historial.add(
                            Movimiento(
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
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 22.dp)
            ) {
                Estadistica(
                    nombre = "Total incrementos:",
                    valor = incrementos
                )

                Spacer (
                    modifier = Modifier.height(10.dp)
                )

                Estadistica(
                    nombre = "Total decrementos:",
                    valor = decrementos
                )

                Spacer (
                    modifier = Modifier.height(10.dp)
                )

                Estadistica(
                    nombre = "Valor máximo:",
                    valor = max
                )

                Spacer (
                    modifier = Modifier.height(10.dp)
                )

                Estadistica(
                    nombre = "Valor mínimo:",
                    valor = min
                )

                Spacer (
                    modifier = Modifier.height(10.dp)
                )

                Estadistica(
                    nombre = "Total cambios:",
                    valor = totalCambios
                )

                Spacer (
                    modifier = Modifier.height(10.dp)
                )

                Text (
                    text = "Historial:",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer (
                    modifier = Modifier.height(10.dp)
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(5),
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    items (historial) { movimiento ->
                        ItemHistorial(
                            movimiento = movimiento
                        )
                    }
                }

                Button(
                    onClick = {
                        contador = 0
                        incrementos = 0
                        decrementos = 0
                        max = 0
                        min = 0
                        historial.clear()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text (
                        text = "Reiniciar"
                    )
                }
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