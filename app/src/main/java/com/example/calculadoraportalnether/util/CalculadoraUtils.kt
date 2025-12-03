package com.example.calculadoraportalnether.util

fun calcularOverword(valor: String): String {
    return (valor.toIntOrNull()?.div(8) ?: "").toString()
}

fun calcularNether(valor: String): String {
    return (valor.toIntOrNull()?.times(8) ?: "").toString()
}