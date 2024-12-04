package com.example.greetingapp

//importado de clases boilerplate
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.greetingapp.ui.theme.GreetingAppTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//la clase principal que se crea con emptyActivity
//hereda de ComponentActivity
class MainActivity : ComponentActivity() {
    //onCreate es el entrypoint
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //la funcion setContent dentro de onCreate sirve para definir el layout
        //lo hace a traves de funciones composable
        //todas las funciones marcadas con @Composable pueden ser llamadas desde setContent
        //las funciones composables tambien pueden ser llamadas desde otras funciones composables
        //la anotacion composable indica al compilador de Kotlin que la funcion es usada por Jetpack compose
        //para generar la UI
        setContent {
            GreetingAppTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Victor",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//la funcion que se llama para construir la interface
//las funciones composable inician con mayuscula
//las funciones composable no retornan un valor
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //se agrega un surface que es un contenedor como Box
    Surface(color = Color.Black) {
        Text(
            color = Color.White,
            text = "Hi, my name is $name!",
            //un Modifier permite decorar un composable
            modifier = modifier.padding(24.dp)
        )
    }
}

//las funciones preview anotadas con @Preview y @Composable
//son funciones que permiten visualizar un preview en AS sin tener que construir toda la app
@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    GreetingAppTheme {
        Greeting("Victor")
    }
}