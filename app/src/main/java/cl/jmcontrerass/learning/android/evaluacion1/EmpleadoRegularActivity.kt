package cl.jmcontrerass.learning.android.evaluacion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


// clase correspondiente al empleado a contrata
class EmpleadoRegularActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // contenido vinculado a archivo activity_empleado_regular.xml
        setContentView(R.layout.activity_empleado_regular)

        // valor de lectura que genera instancia vinculada a través del id al botón para calcular
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        // se desarrolla ante el evento de click sobre el botón señalado
        btnCalcular.setOnClickListener {

            // se vincula el resultado al id de la vista de texto que mostrará el resultado
            val resultado = findViewById<TextView>(R.id.tvResultado)
            // se vincula la entrada de texto a la variable de lectura que almacena el valor
            val bruto = findViewById<TextView>(R.id.etBruto)

            // se parsea el valor ingresado a double con manejo de nulo
            val b = bruto.text.toString().toDoubleOrNull() ?:0.0

            // instancia de la clase empleado con el valor ingresado
            val empleado = EmpleadoRegular(b)
            // se invoca la función para calcula el valor esperado almacenado en variable de lectura
            val liquido = empleado.calcularLiquido()
            // se muestra el resultado vinculado a la vista de texto anteriormente
            resultado.text = "El pago líquido es de ${liquido}"
        }
    }

    // función para finalizar la actividad y volver a la pantalla de inicio
    fun volverAtras(view: View) {
        finish()
    }
}