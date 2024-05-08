package com.example.myapppersonas.ui.theme

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapppersonas.screens.ListaPersonaViewModel


@Composable
fun ListUser(modifier:Modifier= Modifier) {
    val listaPersonaViewModel : ListaPersonaViewModel = viewModel()
    listaPersonaViewModel.recuperarPersonas()
    val state = listaPersonaViewModel.personaUiState
    when(state){
       is ListaPersonaViewModel.PersonaUiState.Error -> {
       Text(text = "Error")
       }
        is ListaPersonaViewModel.PersonaUiState.Loading -> {
            Text(text = "CARGANDO")
        }
        is ListaPersonaViewModel.PersonaUiState.Success -> {
            val resultado = state.personas
            Text(text = resultado)
//            val listaPersonas = listOf(1,2,3)
//            LazyColumn(modifier = modifier){
//
//                items(listaPersonas){ i ->
//                    UserProfileCard(id = i, firstName ="Fran" , lastName = "mesa", age = 25 + i)
//                }
//            }
        }
    }
}


@Composable
fun UserProfileCard(id: Int, firstName: String, lastName: String, age: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.Blue),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Perfil de Usuario $firstName",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Divider(color = Color.Gray, thickness = 0.5.dp)
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = "ID:",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                Text(
                    text = id.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = "Nombre: ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                Text(
                    text = "$firstName $lastName",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = "Edad: ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                Text(
                    text = age.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun prew() {
    ListUser()
}
