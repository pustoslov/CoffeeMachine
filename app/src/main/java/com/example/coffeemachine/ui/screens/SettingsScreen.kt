package com.example.coffeemachine.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeemachine.R
import com.example.coffeemachine.ui.ViewModel
import com.example.coffeemachine.ui.components.SettingsOptions
import com.example.coffeemachine.ui.theme.Gray
import com.example.coffeemachine.ui.theme.Orange
import com.example.coffeemachine.ui.theme.White
import com.example.coffeemachine.ui.theme.monserrat

@Composable
fun SettingsScreen(
    viewModel: ViewModel,
    onSaveClick: () -> Unit
) {

    val uiState = viewModel.coffeeUiStateFlow.collectAsState()

    var isFirstPicked by remember {
        mutableStateOf(uiState.value.image == R.drawable.with_milk)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row {

            Spacer(modifier = Modifier.width(180.dp))

            Column {
                SettingsOptions(
                    viewModel = viewModel
                )
                Spacer(modifier = Modifier.height(64.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(162.dp)
                        .height(52.dp)
                        .then(
                            if (viewModel.isCanSave) {
                                Modifier
                                    .clickable {
                                        viewModel.saveCoffee()
                                        onSaveClick()
                                    }
                                    .background(Orange, RoundedCornerShape(12.dp))
                            } else {
                                Modifier
                                    .background(Gray, RoundedCornerShape(12.dp))
                            }
                        )
                ) {
                    Text(
                        text = "Сохранить",
                        color = White,
                        fontSize = 20.sp,
                        lineHeight = 20.sp,
                        fontFamily = monserrat,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .offset(30.dp, 0.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.with_milk_no_edge),
                    contentDescription = null,
                    alpha = if (isFirstPicked) 1f else 0.4f,
                    modifier = Modifier
                        .size(287.dp)
                        .clickable {
                            viewModel.updateImage(R.drawable.with_milk)
                            isFirstPicked = true
                        }
                )
                if (isFirstPicked) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .offset(0.dp, -55.dp)
                            .background(Orange, CircleShape)
                            .size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint = White
                        )
                    }
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .offset(-30.dp, 0.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.mokka_no_edge),
                    contentDescription = null,
                    alpha = if (isFirstPicked) 0.4f else 1f,
                    modifier = Modifier
                        .size(287.dp)
                        .clickable {
                            viewModel.updateImage(R.drawable.mokka)
                            isFirstPicked = false
                        }
                )
                if (!isFirstPicked) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .offset(0.dp, -55.dp)
                            .background(Orange, CircleShape)
                            .size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint = White
                        )
                    }
                }
            }

        }
    }

}