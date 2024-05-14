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

class ListaPersonaViewModel : ViewModel() {
    sealed interface PersonaUiState {
        data class Success(val personas: List<Persona>) : PersonaUiState // TODO lista de personas
        object Error : PersonaUiState
        object Loading : PersonaUiState
    }
    var personaUiState: PersonaUiState by mutableStateOf(PersonaUiState.Loading)
        private set

    init {
        recuperarPersonas()
    }

    fun recuperarPersonas() {
        viewModelScope.launch {
            try {
                Log.i("MarsViewModel","Antes de la lista");
                val listResult = PersonaApi.retrofitService.getPersonas()
                Log.i("MarsViewModel","Despues de la lista");
                personaUiState = PersonaUiState.Success(
                  listResult //"Success: ${listResult.size} Mars photos retrieved"// TODO lista de personas
                )
            } catch (e: IOException) {
                personaUiState = PersonaUiState.Error
                Log.i("MarsViewModel", "Algo falló", e);
            }
        }
    }
    fun borrarPersona(id: Int) {
        viewModelScope.launch {
            try {
              val respuesta = PersonaApi.retrofitService.deletePersona(id)
                if (respuesta.isSuccessful){
                    Log.i("borrarPersona", "Persona borrada correctamente")
                    recuperarPersonas()
                }
            } catch (e: IOException) {
                personaUiState = PersonaUiState.Error
                Log.i("MarsViewModel", "Algo falló", e);
            }
        }
    }


}
