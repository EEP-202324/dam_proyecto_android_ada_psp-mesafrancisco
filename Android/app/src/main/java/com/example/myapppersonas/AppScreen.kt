package com.example.myapppersonas

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
            UserScreen(navController )
        }
        composable(Screen.ListUser) {
            // Lógica para la lista de usuarios

            ListUser()
        }
    }
}
