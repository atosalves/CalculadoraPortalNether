package com.example.calculadoraportalnether.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoraportalnether.R

@Composable
fun TelaInicial(onStartClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // Fundo Minecraft
        Image(
            painter = painterResource(id = R.drawable.minecraft_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x80000000))
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo_calculadora),
                contentDescription = null,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Text(
                text = "Bem-vindo!",
                color = Color.White,
                fontSize = 28.sp,
                fontFamily = FontFamily(Font(R.font.minecraft_font))
            )

            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .clickable{onStartClick()}
            ) {
                Box(
                    modifier = Modifier
                        .border(2.dp, Color(0xFF3A3A3A))
                        .padding(2.dp)
                        .background(Color(0xFF7C7C7C))
                        .padding(horizontal = 2.dp, vertical = 2.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ){
                    Box(modifier = Modifier
                        .background(Color(0xFF9B9B9B))
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(),
                        contentAlignment = Alignment.Center){
                        Text("Iniciar cálculos", color = Color.White, style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.minecraft_font)),
                            fontSize = 16.sp,
                            shadow = Shadow(
                                color = Color(0xFF7A7A7A),
                                offset = Offset(4f, 4f),
                                blurRadius = 0f
                            )
                        ))
                    }
                }
            }
        }
    }
}
