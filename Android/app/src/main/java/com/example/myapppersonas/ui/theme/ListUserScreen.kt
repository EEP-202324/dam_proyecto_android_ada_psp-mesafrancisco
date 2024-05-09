package com.example.myapppersonas.ui.theme

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            val listaPersonas = state.personas
      //      Text(text = resultado)
      //      val listaPersonas = listOf(1,2,3)
            LazyColumn(modifier = modifier){

                items(listaPersonas){ p ->
                    UserProfileCard(id = p.id, firstName = p.nombre , lastName = p.apellido, age = p.edad)
                }
            }
        }
    }
}


@Composable
fun UserProfileCard(id: Int, firstName: String, lastName: String, age: Int) {
    Surface(
        modifier = Modifier
            .height(210.dp)
            .padding(12.dp),
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFDAE1E7),
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier
                        .wrapContentSize(),
                    shape = RoundedCornerShape(24.dp),
                    color = Color(0xFFD1F5E1),
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 4.dp, horizontal = 8.dp),
                        text = "Ficha de Usuario $id",
                        fontSize = 12.sp,
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Nombre : $firstName $lastName",
                    fontSize = 24.sp,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(text = "Usuario Aula")

                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Edad $age",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )

                }

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedButton(
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Blue,
                        containerColor = Color.White
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Borrar Usuario",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prew() {
    UserProfileCard(25,"Francisco", "Mesa", 25)
}
