package cl.jmcontrerass.learning.android.evaluacion1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class EmpleadoHonorariosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaHonorarios()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class) // uso de API experimental
@Preview
@Composable
fun PantallaHonorarios() {

    // variables mutables para almacenar lso valores necesarios para el cálculo
    var bruto by remember { mutableStateOf("")}
    var resultado by remember { mutableStateOf("")}

    // se obtiene contexto y conversión para acceder a las funciones de la actividad
    val contexto = LocalContext.current as ComponentActivity

    // columna que organiza los elementos verticalmente
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        // texto con el título de la pantalla y atributos de estilo específicos
        Text(
            text = "Empleado Honorarios",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
        )
        // espaciado entre elementos
        Spacer(modifier = Modifier.height(40.dp))

        // campo para el ingreso del valor que será almacenado en variable 'bruto'
        TextField(
            placeholder = {Text("Ingrese sueldo bruto")},
            value = bruto,
            onValueChange = {bruto = it},
            // opción de uso de teclado del dispositivo móvil
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(20.dp))

        // botón que activa el cálculo del sueldo líquido
        Button(onClick = {
            // valor de lectura que parsea la variable bruto a double y maneja nulo
            val b = bruto.toDoubleOrNull() ?: 0.0
            // valor de lectura que almacena el resultado del cálculo líquido
            val liquido = EmpleadoHonorarios(b).calcularLiquido()
            // almacena el string que se mostrará como resultado
            resultado = "El pago líquido es de ${liquido}"
        }){
            Text("Calcular Sueldo Líquido")
        }
        Spacer(modifier = Modifier.height(20.dp))

        // se muestra el resultado
        Text(resultado)
        Spacer(modifier = Modifier.height(60.dp))

        // botón que finaliza la actividad del contexto para volver a la pantalla inicial
        Button(onClick = { contexto.finish()}) {
            Text("<- Volver")
        }
    }
}