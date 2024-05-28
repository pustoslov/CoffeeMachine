package com.example.coffeemachine.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeemachine.R
import com.example.coffeemachine.ui.CoffeeUiState
import com.example.coffeemachine.ui.theme.GrayBrown
import com.example.coffeemachine.ui.theme.LightestBrown
import com.example.coffeemachine.ui.theme.Orange
import com.example.coffeemachine.ui.theme.SemiDarkBrown
import com.example.coffeemachine.ui.theme.monserrat

@Composable
fun CoffeeCard(
    coffeeUiState: CoffeeUiState,
    isFree: Boolean
) {
    Column(
        modifier = Modifier
            .width(227.dp)
            .clip(RoundedCornerShape(6.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(25, 17, 14),
                            Color(16, 9, 9)
                        )
                    )
                )
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = coffeeUiState.image),
                contentDescription = null,
                modifier = Modifier
                    .size(210.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(57.dp)
                    .offset(0.dp, -8.dp)
            ) {
                Text(
                    text = coffeeUiState.name,
                    color = LightestBrown,
                    fontSize = 17.sp,
                    lineHeight = 24.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = monserrat,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp)
                    .background(SemiDarkBrown)
            ) {
                if (!isFree) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Text(
                            text = "0.33",
                            color = GrayBrown,
                            fontSize = 16.sp,
                            fontFamily = monserrat,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "${coffeeUiState.cost} ₽",
                            color = Orange,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = monserrat
                        )
                    }
                } else {
                    Text(
                        text = "0.33",
                        color = GrayBrown,
                        fontSize = 16.sp,
                        fontFamily = monserrat,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun CardPrev() {
    CoffeeCard(
        coffeeUiState = CoffeeUiState(
            name = "Капучино Эконом",
            cost = "199",
            image = R.drawable.with_milk
        ),
        isFree = false
    )
}