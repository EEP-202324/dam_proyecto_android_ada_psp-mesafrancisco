package com.example.myapppersonas.screens


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapppersonas.model.Persona
import com.example.myapppersonas.network.PersonaApi
import kotlinx.coroutines.launch
import java.io.IOException

class PersonaViewModel : ViewModel() {
    sealed interface PersonaUiState {
        data class Success(val persona: Unit) : PersonaUiState // TODO lista de personas
        object Error : PersonaUiState

        object Loading : PersonaUiState
    }
    var personaUiState: PersonaUiState by mutableStateOf(PersonaUiState.Loading)
        private set

    init {
        anadirPersonas(nombre = "String", apellido = "String", edad = 1)
    }

    fun anadirPersonas(
        nombre : String, apellido : String, edad : Int
    ) {
        viewModelScope.launch {
//            try {
//                Log.i("MarsViewModel","Antes de la persona");
//                val nuevaPersona = Persona(id = id, nombre = nombre, apellido = apellido, edad = edad)
//                val personaAnadida = PersonaApi.retrofitService.addPersona()
//                Log.i("MarsViewModel","Despues de la persona");
//                personaUiState = PersonaUiState.Success(
//                     //"Success: ${listResult.size} Mars photos retrieved"// TODO lista de personas
//                )
//            } catch (e: IOException) {
//                personaUiState = PersonaUiState.Error
//                Log.i("MarsViewModel", "Algo falló", e);
//            }
        }
    }
}
