package com.example.calculadoraportalnether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.calculadoraportalnether.data.CoordenadasSalvas
import com.example.calculadoraportalnether.ui.Salvos

class SalvosActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataStore = CoordenadasSalvas(applicationContext)

        setContent {
            Salvos(
                dataStore = dataStore,
                onBackClick = { finish() }
            )
        }
    }
}
