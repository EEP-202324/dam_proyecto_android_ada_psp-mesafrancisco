package com.example.myapppersonas.ui.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListUser(navController: NavController) {
    Text(text = "Holas")
}


@Composable
fun UserProfileCard(name: String, age: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {

            Spacer(modifier = Modifier.width(16.dp))

            // Nombre y edad
            Column {
                Text(
                    text = "Nombre: $name",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black
                )
                Text(
                    text = "Edad: $age",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prew() {
    UserProfileCard("fran", 26)
}
