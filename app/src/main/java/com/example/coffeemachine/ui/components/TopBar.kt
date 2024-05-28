package com.example.coffeemachine.ui.components

import android.os.Build
import android.widget.TextClock
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.coffeemachine.R
import com.example.coffeemachine.ui.ViewModel
import com.example.coffeemachine.ui.theme.DarkBrown
import com.example.coffeemachine.ui.theme.Brown
import com.example.coffeemachine.ui.theme.LighterBrown
import com.example.coffeemachine.ui.theme.monserrat

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TopBar(
    viewModel: ViewModel,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .drawBehind {
                drawLine(
                    color = DarkBrown,
                    Offset(0f, 54f * density),
                    Offset(size.width, 54f * density),
                    strokeWidth = 1f * density
                )
            }
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 26.dp)
                .fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { onClick() }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.u),
                    contentDescription = null
                )
                Spacer(
                    modifier = Modifier
                        .width(12.dp)
                )
                Text(
                    text = "RUNERO Touch",
                    color = Brown,
                    fontFamily = monserrat,
                    fontWeight = FontWeight.Medium
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(88.dp)
                    .fillMaxHeight()
            ) {
                AndroidView(
                    factory = { context ->
                        TextClock(context).apply {
                            textSize = 16f
                            setTextColor(ContextCompat.getColor(context, R.color.medium_brown))
                            format12Hour = "kk:mm"
                            typeface = resources.getFont(R.font.montserrat_regular)
                        }
                    }
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
                    .background(DarkBrown)
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(88.dp)
                    .fillMaxHeight()
            ) {

                val temp = viewModel.temperature.collectAsState()

                Text(
                    text = "${temp.value}°",
                    color = LighterBrown,
                    fontSize = 16.sp,
                    fontFamily = monserrat,
                    fontWeight = FontWeight.Normal
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
                    .background(DarkBrown)
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(88.dp)
                    .fillMaxHeight()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ru),
                        contentDescription = null,
                        modifier = Modifier
                            .size(11.dp)
                    )
                    Text(
                        text = " RU",
                        color = LighterBrown,
                        fontSize = 16.sp,
                        fontFamily = monserrat,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}