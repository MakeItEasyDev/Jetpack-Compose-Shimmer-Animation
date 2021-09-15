package com.jetpack.shimmeranimation

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerAnimateItem() {
    val ShimmerColors = listOf(
        Color.LightGray.copy(0.9f),
        Color.LightGray.copy(0.2f),
        Color.LightGray.copy(0.9f)
    )

    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1200, easing = FastOutLinearInEasing),
            RepeatMode.Reverse
        )
    )

    val brush = Brush.linearGradient(
        colors = ShimmerColors,
        start = Offset(10f, 10f),
        end = Offset(translateAnim.value, translateAnim.value)
    )

    ShimmerItem(brush)
}

@Composable
fun ShimmerItem(brush: Brush) {
    Column(
        modifier = Modifier.padding(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
        ) {
            Spacer(
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .background(brush)
            )

            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "",
                        modifier = Modifier
                            .height(20.dp)
                            .weight(1.0f)
                            .background(brush)
                    )
                    Divider(modifier = Modifier.weight(0.1f))
                    Text(
                        text = "",
                        modifier = Modifier
                            .weight(0.4f)
                            .height(20.dp)
                            .background(brush)
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                 Text(
                     text = "",
                     modifier = Modifier
                         .fillMaxWidth()
                         .height(20.dp)
                         .background(brush)
                 )
            }
        }
    }
}























