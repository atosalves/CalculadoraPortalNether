package com.example.calculadoraportalnether

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.calculadoraportalnether.ui.TelaInicial

class TelaInicialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TelaInicial(
                onStartClick = {
                    startActivity(Intent(this, CalculadoraActivity::class.java))
                }
            )
        }
    }
}
