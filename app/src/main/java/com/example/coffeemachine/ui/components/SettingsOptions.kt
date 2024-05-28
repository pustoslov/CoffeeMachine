package com.example.coffeemachine.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeemachine.ui.ViewModel
import com.example.coffeemachine.ui.theme.LighterBrown
import com.example.coffeemachine.ui.theme.LightestBrown
import com.example.coffeemachine.ui.theme.Orange
import com.example.coffeemachine.ui.theme.RedishBrown
import com.example.coffeemachine.ui.theme.monserrat

@Composable
fun SettingsOptions(
    viewModel: ViewModel
) {

    val uiState = viewModel.coffeeUiStateFlow.collectAsState()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .width(418.dp)
    ) {
        Text(
            text = "Наименование",
            fontSize = 16.sp,
            fontFamily = monserrat,
            fontWeight = FontWeight.SemiBold,
            color = LightestBrown,
            lineHeight = 22.sp
        )
        Spacer(
            modifier = Modifier
                .height(12.dp)
        )
        InputField(
            string = uiState.value.name,
            onValueChange = { viewModel.updateName(it) }
        )
        Spacer(
            modifier = Modifier
                .height(32.dp)
        )
        Text(
            text = "Цена",
            fontSize = 16.sp,
            fontFamily = monserrat,
            fontWeight = FontWeight.SemiBold,
            color = LightestBrown,
            lineHeight = 22.sp
        )
        Spacer(
            modifier = Modifier
                .height(12.dp)
        )
        InputField(
            string = uiState.value.cost,
            onValueChange = { viewModel.updateCost(it) },
            isDigits = true
        )
        Spacer(
            modifier = Modifier
                .height(12.dp)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .border(1.dp, RedishBrown, RoundedCornerShape(12.dp))
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Text(
                    text = "Продавать бесплатно",
                    fontSize = 14.sp,
                    fontFamily = monserrat,
                    fontWeight = FontWeight.Medium,
                    color = LighterBrown,
                    lineHeight = 22.sp
                )
                Switch(
                    checked = viewModel.isFree,
                    onCheckedChange = {
                        viewModel.isFree = !viewModel.isFree
                        if (viewModel.isFree) {
                            viewModel.updateCost("0")
                        } else {
                            if (viewModel.coffee.cost == "0") {
                                viewModel.updateCost("199")
                            } else {
                                viewModel.updateCost(viewModel.coffee.cost)
                            }
                        }
                    },
                    colors = SwitchDefaults.colors(
                        checkedTrackColor = Orange,
                        checkedThumbColor = Color.White
                    )
                )
            }
        }
    }

}