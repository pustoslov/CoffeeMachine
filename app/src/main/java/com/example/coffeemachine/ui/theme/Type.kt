package com.example.coffeemachine.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.coffeemachine.R


val monserrat = FontFamily(
    Font(
        R.font.montserrat_regular,
        weight = FontWeight.Normal
    ),
    Font(
        R.font.montserrat_medium,
        weight = FontWeight.Medium
    ),
    Font(
        R.font.montserrat_semibold,
        weight = FontWeight.SemiBold
    ),
    Font(
        R.font.montserrat_bold,
        weight = FontWeight.Bold
    )
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)