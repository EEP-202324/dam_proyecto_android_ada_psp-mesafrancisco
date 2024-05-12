package com.example.myapppersonas.screens


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapppersonas.model.Persona
import com.example.myapppersonas.network.PersonaApi
import com.example.myapppersonas.repository.PersonaRepository
import kotlinx.coroutines.launch
import java.io.IOException

class PersonaViewModel : ViewModel() {
    sealed interface PersonaUiState {
        data class Success(val persona: Unit) : PersonaUiState
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
            try {
                val nuevaPersona = Persona(0, nombre, apellido, edad)
                val exito = PersonaRepository(PersonaApi.retrofitService).addPersona(nuevaPersona)
                if (exito) {
                    personaUiState = PersonaUiState.Success(Unit)
                } else {
                    personaUiState = PersonaUiState.Error
                }
            } catch (e: IOException) {
                personaUiState = PersonaUiState.Error
                Log.e("PersonaViewModel", "Error al añadir persona", e)
            }
        }
    }
}
