package plat.lab4.hernandez_maldonado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import plat.lab4.hernandez_maldonado.ui.theme.LAB4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LAB4Theme {
            }
        }
    }
}

@Composable
fun LogIn(modifier: Modifier = Modifier) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .border(
                width = 8.dp,
                color = Color(0xFF126E22)
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            modifier = Modifier
                .alpha(0.4f)
                .size(350.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 35.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Universidad del Valle de Guatemala",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            Text (
                text = "Programación de plataformas móviles, Sección 30",
                fontSize = 23.sp,
                textAlign = TextAlign.Center,
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text (
                    text = "INTEGRANTES",
                    fontWeight = FontWeight.Bold
                )
                Column (
                    horizontalAlignment = Alignment.End
                ) {
                    Text("Valeria Hernández")
                    Text("José Pinto")
                    Text("Jorge Martínez")
                }
            }
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text (
                    text = "CATEDRÁTICO",
                    fontWeight = FontWeight.Bold
                )
                Text("Juan Carlos Durini")
            }
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Column (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Valeria Hernández Maldonado")
                Text("25086")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LAB4Theme {
        LogIn()
    }
}