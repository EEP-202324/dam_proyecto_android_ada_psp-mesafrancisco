package com.example.myapppersonas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapppersonas.network.Persona
import com.example.myapppersonas.ui.theme.MyAppPersonasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppPersonasTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AddPersonaScreen()
                }
            }
        }
    }
}

@Composable
fun AddPersonaScreen() {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }

    // Lista temporal de personas para simular datos
    val personas = remember { mutableStateListOf<Persona>() }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Añade tus Datos",
            color = Color.Blue,
            style = TextStyle(
                fontFamily = FontFamily.Serif,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )

        OutlinedTextField(
            value = apellido,
            onValueChange = { apellido = it },
            label = { Text("Apellido") }
        )

        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    // Agregar persona a la lista (esto sería reemplazado por la llamada a la API)
                    // personas.add(Persona(nombre, apellido, edad.toInt()))

                    // Limpiar campos después de agregar persona
                    nombre = ""
                    apellido = ""
                    edad = ""
                }
            ) {
                Text("Agregar Persona")
            }

            Button(
                onClick = {
                    // Mostrar personas (esto podría ser reemplazado por la navegación a otra pantalla)
                    //personas.forEach { persona ->
                   //     println("Nombre: ${persona.nombre}, Apellido: ${persona.apellido}, Edad: ${persona.edad}")
                   // }
                }
            ) {
                Text("Mostrar Personas")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAppPersonasTheme {
        AddPersonaScreen()
    }
}

