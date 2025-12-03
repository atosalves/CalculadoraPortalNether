package com.example.calculadoraportalnether.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoraportalnether.R
import com.example.calculadoraportalnether.util.calcularNether
import com.example.calculadoraportalnether.util.calcularOverword

@Composable
fun CalculadoraScreen() {

    var overwordPosicaoX by remember { mutableStateOf("") }
    var overwordPosicaoZ by remember { mutableStateOf("") }

    var netherPosicaoX by remember { mutableStateOf("") }
    var netherPosicaoZ by remember { mutableStateOf("") }

    Image(
        painter = painterResource(id = R.drawable.minecraft_background),
        contentDescription = "Background de terra",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )

    Column (
        modifier = Modifier
            .padding(WindowInsets.statusBars.add(WindowInsets.navigationBars).asPaddingValues())
            .background(Color(0x8C000000))
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_calculadora),
                contentDescription = "Logo calculadora"
            )
        }

        Column(
            modifier = Modifier
                .padding(5.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        )
        {
            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
            ) {
                Text(
                    text = "Coordenadas no Overword",
                    color = Color.White,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.minecraft_font)),
                        fontSize = 16.sp
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MinecraftTextField(
                        value = overwordPosicaoX,
                        onValueChange = { valor ->
                            overwordPosicaoX = valor
                            netherPosicaoX = calcularOverword(valor)
                        },
                        label = "X",
                        modifier = Modifier.weight(1f)
                    )

                    MinecraftTextField(
                        value = overwordPosicaoZ,
                        onValueChange = { valor ->
                            overwordPosicaoZ = valor
                            netherPosicaoZ = calcularOverword(valor)
                        },
                        label = "Z",
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 15.dp)
            ) {
                Text(
                    text = "Coordenadas no Nether",
                    color = Color.White,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.minecraft_font)),
                        fontSize = 16.sp
                    )
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MinecraftTextField(
                        value = netherPosicaoX,
                        onValueChange = { valor ->
                            netherPosicaoX = valor
                            overwordPosicaoX = calcularNether(valor)
                        },
                        label = "X",
                        modifier = Modifier.weight(1f)
                    )

                    MinecraftTextField(
                        value = netherPosicaoZ,
                        onValueChange = { valor ->
                            netherPosicaoZ = valor
                            overwordPosicaoZ = calcularNether(valor)
                        },
                        label = "Z",
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CalculadoraScreenPreview() {
    CalculadoraScreen();
}