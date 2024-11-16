package com.example.meeting7

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.meeting7.model.DataJK
import com.example.meeting7.model.DataJK.isiJK
import com.example.meeting7.ui.view.FormulirView
import com.example.meeting7.ui.view.TampilMahasiswaView
import com.example.meeting7.ui.viewmodel.MahasiswaViewModel

enum class Halaman {
    Form,
    Data
}
@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    Scaffold { isipadding ->
        val uiState by viewModel.uistate.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navHost, startDestination = Halaman.Form.name
        ) {
            composable(route = Halaman.Form.name){
                val konteks = LocalContext.current
                FormulirView(
                    pilihanJK = isiJK.map {
                        isi ->konteks.resources.getString(isi)
                    },
                    onClickButton = {
                        viewModel.saveDataMahasiswa(it)
                        navHost.navigate(Halaman.Data.name)
                    }
                )
            }
            composable(route = Halaman.Data.name){
                TampilMahasiswaView(
                    mhs = uiState
                )
            }
        }
    }
}