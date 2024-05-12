package com.example.myapppersonas

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapppersonas.ui.theme.ListEscuelas
import com.example.myapppersonas.ui.theme.ListUser
import com.example.myapppersonas.ui.theme.Screen
import com.example.myapppersonas.ui.theme.UserScreen


@Composable
fun AppScreen(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Users
    ) {
        composable(Screen.Users) {
            UserScreen(navController, viewModel())
        }
        composable(Screen.ListUser) {
            // Lógica para la lista de usuarios
            ListUser(navController)
        }
        composable(Screen.ListEscuelas) {
            // Lógica para la lista de usuarios
            ListEscuelas(navController)
        }
    }
}
