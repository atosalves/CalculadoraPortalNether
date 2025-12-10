package com.example.calculadoraportalnether.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoraportalnether.R
import com.example.calculadoraportalnether.data.CoordenadasSalvas
import kotlinx.coroutines.launch

@Composable
fun Salvos(
    dataStore: CoordenadasSalvas,
    onBackClick: () -> Unit
) {
    val lista by dataStore.savedList.collectAsState(initial = emptySet())
    val scope = rememberCoroutineScope()

    Image(
        painter = painterResource(id = R.drawable.minecraft_background),
        contentDescription = "Background de terra",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x80000000))
            .padding(16.dp)
    ) {
        LazyColumn {
            items(lista.toList()) { item ->

                val dados = item.split(",")

                if (dados.size == 5) {
                    val (nome, ox, oz, nx, nz) = dados

                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .background(Color(0xFF4A4A4A))
                            .padding(12.dp)
                    ) {
                        Text("Nome: $nome", color = Color.White, fontFamily = FontFamily(Font(R.font.minecraft_font)))
                        Text("Overworld: X=$ox | Z=$oz", color = Color.White, fontFamily = FontFamily(Font(R.font.minecraft_font)))
                        Text("Nether: X=$nx | Z=$nz", color = Color.White, fontFamily = FontFamily(Font(R.font.minecraft_font)))

                        Text(
                            "Excluir",
                            color = Color.Red,
                            fontFamily = FontFamily(Font(R.font.minecraft_font)),
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .clickable {
                                    scope.launch { dataStore.deletarCoordenadas(item) }
                                }
                        )
                    }
                }
            }

        }

        Spacer(modifier = Modifier.height(20.dp))
        
        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .clickable { onBackClick() }
        ) {
            Box(
                modifier = Modifier
                    .border(2.dp, Color(0xFF3A3A3A))
                    .padding(2.dp)
                    .background(Color(0xFF7C7C7C))
                    .padding(horizontal = 2.dp, vertical = 2.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFF9B9B9B))
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Voltar", color = Color.White, fontFamily = FontFamily(Font(R.font.minecraft_font)))
                }
            }
        }
    }
}
