package com.example.meeting7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.meeting7.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(Mahasiswa())

    val uistate: StateFlow<Mahasiswa> = _uiState.asStateFlow()

    fun saveDataMahasiswa(
        ls : MutableList<String>
    ){
        _uiState.update { data ->
            data.copy(
                nama = ls[0],
                gender = ls[1],
                email = ls[2],
                nohp = ls[3],
                alamat = ls[4],
                nim = ls[5]
            )
        }
    }
}