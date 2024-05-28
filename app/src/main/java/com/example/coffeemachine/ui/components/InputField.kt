package com.example.coffeemachine.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeemachine.R
import com.example.coffeemachine.ui.theme.LighterBrown
import com.example.coffeemachine.ui.theme.Milk
import com.example.coffeemachine.ui.theme.RedishBrown
import com.example.coffeemachine.ui.theme.monserrat

@Composable
fun InputField(
    string: String,
    onValueChange: (String) -> Unit,
    isDigits: Boolean = false
) {

    TextField(
        value = string,
        onValueChange = { value -> onValueChange(value) },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Milk,
            unfocusedTextColor = Milk,
            focusedContainerColor = RedishBrown,
            unfocusedContainerColor = RedishBrown,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
                       if (isDigits) {
                           Icon(
                               painter = painterResource(id = R.drawable.rub),
                               contentDescription = null,
                               tint = LighterBrown
                           )
                       }
        },
        keyboardOptions = if (isDigits) {
            KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Done
            )
        } else {
               KeyboardOptions(
                   keyboardType = KeyboardType.Text,
                   imeAction = ImeAction.Done
               )
               },
        textStyle = TextStyle(
            fontFamily = monserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 20.sp
        ),
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .fillMaxWidth()
    )

}