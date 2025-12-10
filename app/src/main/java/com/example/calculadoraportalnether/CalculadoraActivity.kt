package com.example.calculadoraportalnether

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.calculadoraportalnether.ui.CalculadoraTela

class CalculadoraActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CalculadoraTela(
                onOpenSaved = {
                    startActivity(Intent(this, SalvosActivity::class.java)) // OK
                }
            )
        }
    }
}
