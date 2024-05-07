package com.example.myapppersonas.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.navigation.NavController
import com.example.myapppersonas.model.Persona
@Composable
fun UserScreen(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }

    // Lista mutable de personas para almacenar las personas agregadas
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
                    // Agregar persona a la lista
                    personas.add(Persona(nombre, apellido, edad.toInt()))

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
                    navController.navigate(Screen.ListUser)
                    personas.forEach {
                    }
                }
            ) {
                Text("Mostrar Personas")
            }
        }

        // Mostrar la lista de personas agregadas
        personas.forEach { persona ->
            Text("Nombre: ${persona.nombre}, Apellido: ${persona.apellido}, Edad: ${persona.edad}")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAppPersonasTheme {
       // AddPersonaScreen()
    }
}
