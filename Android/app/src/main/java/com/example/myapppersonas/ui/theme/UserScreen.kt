package com.example.myapppersonas.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapppersonas.R
import com.example.myapppersonas.model.Persona
import com.example.myapppersonas.screens.PersonaViewModel


@Composable
fun UserScreen(navController: NavController, personaViewModel: PersonaViewModel) {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }

    // Lista mutable de personas para almacenar las personas agregadas
    val personas = remember { mutableStateListOf<Persona>() }
        // Fondo de la pantalla
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterStart
        ) {
            // Fondo blanco
            Image(
                painter = painterResource(id = R.drawable.fondi),
                contentDescription = "Fondo blanco",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Inscripción",
                color = Color.Black,
                style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Esta aplicación te ayudara a gestionar los usuarios que vendran a Aula, por favor, añade tus datos personales y podras añadir y mostrarlos.",
                color = Color.Black,
                style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
            )

            OutlinedTextField(
                value = apellido,
                onValueChange = { apellido = it },
                label = { Text("Apellido") },
            )

            OutlinedTextField(
                value = edad,
                onValueChange = { edad = it },
                label = { Text("Edad") },
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        if (nombre != "" && apellido != "" && edad != "") {
                            personaViewModel.anadirPersonas(nombre, apellido, edad.toInt())
                        }
                        nombre = ""
                        apellido = ""
                        edad = ""
                    }
                ) {
                    Text("Agregar Persona")
                }

                Button(
                    onClick = {
                        navController.navigate(Screen.ListUser)
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
