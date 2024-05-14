package com.example.myapppersonas.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapppersonas.R
import com.example.myapppersonas.screens.EscuelasViewModel

@Composable
fun ListEscuelas(navController: NavController, modifier: Modifier = Modifier) {
    val escuelasViewModel: EscuelasViewModel = viewModel()
    escuelasViewModel.recuperarEscuelas()
    val state = escuelasViewModel.personaUiState
    Box(modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.uni1__3_),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        when (state) {
            is EscuelasViewModel.EscuelaUiState.Error -> {
                Text(text = "Error")
            }
            is EscuelasViewModel.EscuelaUiState.Loading -> {
                Text(text = "CARGANDO")
            }
            is EscuelasViewModel.EscuelaUiState.Success -> {
                val listaPersonas = state.escuelas
                LazyColumn(modifier = modifier) {
                    items(listaPersonas) { p ->
                        EscuelaCard(
                            id = p.id,
                            nombreEscuela = p.nombre,
                            especialidad = p.especialidad,
                            numeroDeCaseta = p.numeroDeCaseta
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    StandardFab3(navController = navController)
                }
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    contentAlignment = Alignment.BottomStart
                ) {
                    StandardFab4(navController)
                }
            }
        }
    }
}

@Composable
fun EscuelaCard(id: Int, nombreEscuela: String, especialidad: String, numeroDeCaseta: Int) {
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
                        text = "Escuela numero $id",
                        fontSize = 12.sp,
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Nombre : $nombreEscuela",
                    fontSize = 24.sp,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(text = "Escuela Aula")

                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Numero de caseta: $numeroDeCaseta",
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
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    contentAlignment = Alignment.BottomStart
                ) {

                }
            }
        }
    }
}
@Composable
fun StandardFab3(navController: NavController, modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = { navController.navigate(Screen.Users) },
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Text(text = "Añadir Usuario")
            Spacer(modifier = Modifier.height(8.dp))
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
        }
    }
}


@Composable
fun StandardFab4(navController: NavController, modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = { navController.navigate(Screen.ListUser) },
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.error

    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Volver")
    }
}
@Preview(showBackground = true)
@Composable
fun prew2() {
    UserProfileCard(25,"Francisco", "Mesa", 25)
}
