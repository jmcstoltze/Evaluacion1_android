package cl.jmcontrerass.learning.android.evaluacion1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// definición de jerarquía de clases
abstract class Empleado {

    //función que será implementada por las clases derivadas
    abstract fun calcularLiquido(): Double
}
class EmpleadoHonorarios(val sueldoBruto:Double) : Empleado() {
    // descuenta el 13% de retención
    override fun calcularLiquido(): Double = sueldoBruto * 0.87
}
class EmpleadoRegular(val sueldoBruto:Double) : Empleado() {
    // descuenta el 20% de retención
    override fun calcularLiquido(): Double = sueldoBruto * 0.80
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaInicio()
        }
    }
}

@Preview // uso de vista previa
@Composable // define la interfaz de usuario
fun PantallaInicio() {

    // valor de lectura que obtiene y define el contexto
    val contexto = LocalContext.current as ComponentActivity

    // columna que contiene el aspecto de la interfaz centrada tanto vertical como horizontalmente
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        // espacio para texto donde se escribe el título de la pantalla
        Text(
            text = "Cálculo Pagos Líquidos",

            // características de estilo del texto
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )

        // espaciado entre elementos
        Spacer(modifier = Modifier.height(40.dp))

        // botón 1 con dimensionado específico y funcionalidad al hacer click sobre él
        Button(modifier = Modifier.height(60.dp).width(210.dp), onClick = {

            // instancia de la clase Intent para iniciar actividad de dirigir a la página
            // del cálculo de salario de empleado a honorario
            val intent: Intent = Intent(contexto, EmpleadoHonorariosActivity::class.java)
            contexto.startActivity(intent)
        }){
            Text("Empleado Honorarios")
        }
        Spacer(modifier = Modifier.height(20.dp))

        // botón 2 con dimensionado específico y funcionalidad al hacer click sobre él
        Button(modifier = Modifier.height(60.dp).width(210.dp), onClick = {

            // instancia de la clase Intent para iniciar actividad de dirigir a la página
            // del cálculo de salario de empleado a contrato
            val intent:Intent = Intent(contexto, EmpleadoRegularActivity::class.java)
            contexto.startActivity(intent)
        }) {
            Text("Empleado Regular")
        }
    }
}