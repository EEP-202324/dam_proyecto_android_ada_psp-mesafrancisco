package com.example.myapppersonas.ui.theme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapppersonas.AppScreen


// aqui va la gestion del navaController

@Composable
fun App(navController: NavHostController = rememberNavController()) {
    AppScreen(navController = navController)
}
object Screen{
        val Users = "Users"
        val ListUser = "ListUser"
}
