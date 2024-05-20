package com.example.myapppersonas.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapppersonas.model.Escuela
import com.example.myapppersonas.network.EscuelaApi
import kotlinx.coroutines.launch
import java.io.IOException

class EscuelasViewModel : ViewModel() {
    sealed interface EscuelaUiState {
        data class Success(val escuelas: List<Escuela>) : EscuelaUiState // TODO lista de personas
        object Error : EscuelaUiState
        object Loading : EscuelaUiState
    }
    var personaUiState: EscuelaUiState by mutableStateOf(EscuelaUiState.Loading)
        private set

    init {
        recuperarEscuelas()
    }

    fun recuperarEscuelas() {
        viewModelScope.launch {
            try {
                Log.i("MarsViewModel","Antes de la lista");
                val listResult = EscuelaApi.retrofitService.getEscuelas()
                Log.i("MarsViewModel","Despues de la lista");
                personaUiState = EscuelaUiState.Success(
                    listResult //"Success: ${listResult.size} Mars photos retrieved"// TODO lista de personas
                )
            } catch (e: IOException) {
                personaUiState = EscuelaUiState.Error
                Log.i("MarsViewModel", "Algo falló", e);
            }
        }
    }
}