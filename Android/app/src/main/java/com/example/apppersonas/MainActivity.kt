package com.example.personas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserForm(onSubmit = { userData -> /* Aquí puedes enviar los datos al servidor */ },
                        onShowData = { /* Aquí puedes mostrar los datos introducidos */ })
                }
            }
        }
    }
}

@Composable
fun UserForm(onSubmit: (UserData) -> Unit, onShowData: () -> Unit) {
    var id by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = id,
            onValueChange = { id = it },
            label = { Text("ID") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = apellidos,
            onValueChange = { apellidos = it },
            label = { Text("Apellidos") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { onSubmit(UserData(id, nombre, apellidos, edad)) }) {
                Text("Enviar")
            }
            Button(onClick = onShowData) {
                Text("Mostrar Datos")
            }
        }
    }
}

// Definición del modelo de datos
data class UserData(
    val id: String,
    val nombre: String,
    val apellidos: String,
    val edad: String
)

@Preview(showBackground = true)
@Composable
fun UserFormPreview() {
    PersonasTheme {
        UserForm(onSubmit = {}, onShowData = {})
    }
}

@Composable
fun PersonasTheme(content: @Composable () -> Unit) {

}