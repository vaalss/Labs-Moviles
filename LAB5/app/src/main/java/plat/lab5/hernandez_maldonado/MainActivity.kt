package plat.lab5.hernandez_maldonado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import plat.lab5.hernandez_maldonado.ui.theme.LAB5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LAB5Theme {
                View()
            }
        }
    }
}

@Composable
fun View(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
           modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text (
                    text = "Sábado",
                    style = MaterialTheme.typography.headlineMedium
                )
                Text (
                    text = "12 de diciembre",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            OutlinedButton(
                onClick = {}
            ) {
                Text("Terminar jornada")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewPreview() {
    View()
}
