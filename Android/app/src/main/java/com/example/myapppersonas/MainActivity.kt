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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
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

        Button(
            onClick = {
                // val nuevaPersona = Persona(id.toInt() , nombre, apellido, edad.toInt())
                // Aquí debes llamar al método para agregar la persona utilizando Retrofit
                // Por ejemplo: PersonaApi.retrofitService.addPersona(nuevaPersona)
                // Recuerda manejar las respuestas de la API adecuadamente
                // Puedes mostrar un mensaje de éxito o error según la respuesta
                // Por simplicidad, mostraremos un mensaje de éxito
                nombre = ""
                apellido = ""
                edad = ""
            }
        ) {
            Text("Agregar Persona")
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
