package com.example.calculadoraportalnether.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "saved_coords")

class CoordenadasSalvas(private val context: Context) {

    private val SAVED_COORDS = stringSetPreferencesKey("coords")

    val savedList: Flow<Set<String>> = context.dataStore.data.map { prefs ->
        prefs[SAVED_COORDS] ?: emptySet()
    }

    suspend fun salvarCoordenadas(nome: String, overX: String, overZ: String, netherX: String, netherZ: String) {
        val item = "$nome,$overX,$overZ,$netherX,$netherZ"
        context.dataStore.edit { prefs ->
            val old = prefs[SAVED_COORDS] ?: emptySet()
            prefs[SAVED_COORDS] = old + item
        }
    }

    suspend fun deletarCoordenadas(item: String) {
        context.dataStore.edit { prefs ->
            val old = prefs[SAVED_COORDS] ?: emptySet()
            prefs[SAVED_COORDS] = old - item
        }
    }
}

