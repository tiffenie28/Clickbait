package com.example.clickbait.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.clickbait.R

val arialblack = FontFamily(
    Font(R.font.arialblack)
)

val bahnschrift = FontFamily(
    Font(R.font.bahnschrift)
)
val arial = FontFamily(
        Font(R.font.arial)
)
val Typography = Typography(
    labelLarge = TextStyle(
        fontFamily = arialblack,
        fontSize = 12.sp
    ),
   bodyMedium = TextStyle(
        fontFamily = bahnschrift,
        fontSize = 16.sp
    ),
    labelMedium = TextStyle(
        fontFamily = arial,
        fontSize = 12.sp
    ),
)