package com.example.calculadoraportalnether.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoraportalnether.R
import com.example.calculadoraportalnether.data.CoordenadasSalvas
import com.example.calculadoraportalnether.util.calcularNether
import com.example.calculadoraportalnether.util.calcularOverword
import kotlinx.coroutines.launch

@Composable
fun CalculadoraTela(
    onOpenSaved: () -> Unit
) {
    var overwordPosicaoX by remember { mutableStateOf("") }
    var overwordPosicaoZ by remember { mutableStateOf("") }

    var netherPosicaoX by remember { mutableStateOf("") }
    var netherPosicaoZ by remember { mutableStateOf("") }

    var nomePopupAberto by remember { mutableStateOf(false) }
    var nomeParaSalvar by remember { mutableStateOf("") }

    val context = LocalContext.current
    val dataStore = remember { CoordenadasSalvas(context.applicationContext) }
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.minecraft_background),
            contentDescription = "Background de terra",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .padding(WindowInsets.statusBars.add(WindowInsets.navigationBars).asPaddingValues())
                .background(Color(0x8C000000))
                .fillMaxSize()
        ) {

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_calculadora),
                    contentDescription = "Logo calculadora"
                )
            }

            Column(
                modifier = Modifier.padding(5.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {

                Column(modifier = Modifier.padding(horizontal = 15.dp)) {
                    Text(
                        text = "Coordenadas no Overworld",
                        color = Color.White,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.minecraft_font)),
                            fontSize = 16.sp
                        )
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        MinecraftTextField(
                            value = overwordPosicaoX,
                            onValueChange = {
                                overwordPosicaoX = it
                                netherPosicaoX = calcularOverword(it)
                            },
                            label = "X",
                            modifier = Modifier.weight(1f)
                        )

                        MinecraftTextField(
                            value = overwordPosicaoZ,
                            onValueChange = {
                                overwordPosicaoZ = it
                                netherPosicaoZ = calcularOverword(it)
                            },
                            label = "Z",
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Column(modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp)) {

                    Text(
                        text = "Coordenadas no Nether",
                        color = Color.White,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.minecraft_font)),
                            fontSize = 16.sp
                        )
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        MinecraftTextField(
                            value = netherPosicaoX,
                            onValueChange = {
                                netherPosicaoX = it
                                overwordPosicaoX = calcularNether(it)
                            },
                            label = "X",
                            modifier = Modifier.weight(1f)
                        )

                        MinecraftTextField(
                            value = netherPosicaoZ,
                            onValueChange = {
                                netherPosicaoZ = it
                                overwordPosicaoZ = calcularNether(it)
                            },
                            label = "Z",
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .clickable { nomePopupAberto = true }
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
                            Text("Salvar Coordenadas", color = Color.White, fontFamily = FontFamily(Font(R.font.minecraft_font)))
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .clickable { onOpenSaved() }
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
                            Text("Salvos", color = Color.White, fontFamily = FontFamily(Font(R.font.minecraft_font)))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }

        if (nomePopupAberto) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xAA000000))
                    .clickable { nomePopupAberto = false },
                contentAlignment = Alignment.Center
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .background(Color(0xFF4A4A4A))
                        .padding(20.dp)
                        .clickable(enabled = false) { }
                ) {
                    Text(text = "Nome do local", color = Color.White, fontFamily = FontFamily(Font(R.font.minecraft_font)))

                    Spacer(modifier = Modifier.height(8.dp))

                    MinecraftTextField(
                        value = nomeParaSalvar,
                        onValueChange = { nomeParaSalvar = it },
                        label = "Ex: Portal da base",
                        keyboardType = KeyboardType.Text
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {

                        Box(
                            modifier = Modifier
                                .border(2.dp, Color(0xFF3A3A3A))
                                .padding(2.dp)
                                .background(Color(0xFF7C7C7C))
                                .clickable {
                                    if (nomeParaSalvar.isNotBlank()) {
                                        scope.launch {
                                            dataStore.salvarCoordenadas(
                                                nomeParaSalvar,
                                                overwordPosicaoX,
                                                overwordPosicaoZ,
                                                netherPosicaoX,
                                                netherPosicaoZ
                                            )
                                            nomePopupAberto = false
                                            nomeParaSalvar = ""
                                            overwordPosicaoX = ""
                                            overwordPosicaoZ = ""
                                            netherPosicaoX = ""
                                            netherPosicaoZ = ""
                                        }
                                    }
                                }
                                .padding(8.dp)
                        ) {
                            Text("Salvar", color = Color.White, fontFamily = FontFamily(Font(R.font.minecraft_font)))
                        }

                        Box(
                            modifier = Modifier
                                .border(2.dp, Color(0xFF3A3A3A))
                                .padding(2.dp)
                                .background(Color(0xFF7C7C7C))
                                .clickable { nomePopupAberto = false }
                                .padding(8.dp)
                        ) {
                            Text("Cancelar", color = Color.White, fontFamily = FontFamily(Font(R.font.minecraft_font)))
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun CalculadoraTelaPreview() {
    CalculadoraTela(onOpenSaved = {});
}