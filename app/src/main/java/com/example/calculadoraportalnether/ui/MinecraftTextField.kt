package com.example.calculadoraportalnether.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoraportalnether.R

@Composable
fun MinecraftTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(2.dp, Color(0xFF3A3A3A)) // borda externa escura
            .padding(2.dp)
            .background(Color(0xFF7C7C7C)) // cinza médio
            .padding(2.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFF9B9B9B)) // cinza claro
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                modifier = Modifier.fillMaxWidth(),
                value = value,
                onValueChange = onValueChange,
                textStyle = TextStyle(
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.minecraft_font)),
                    fontSize = 16.sp,
                    shadow = Shadow(
                        color = Color(0xFF7A7A7A),
                        offset = Offset(4f, 4f),
                        blurRadius = 0f
                    )
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = label,
                            color = Color.LightGray,
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.minecraft_font)),
                                fontSize = 16.sp
                            ),
                            modifier = Modifier.padding(start = 3.dp)
                        )
                    }
                    innerTextField()
                }
            )
        }
    }
}
