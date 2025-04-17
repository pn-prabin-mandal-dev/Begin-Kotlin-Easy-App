package com.example.gds.beginkotlineasy.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.gds.beginkotlineasy.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun GradientButtonWithText(
    text: String, // Text to display on the button
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier // Modifier for customization
) {
    val gradientBrush = GradientPurple(
        startColor = colorResource(R.color.primary_color), // Start color
        endColor = colorResource(R.color.finalColor)  // End color
    )
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(start = 10.dp, end = 10.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable{
                onClick()
            }
            .background(
                GradientPurple()
            ),
        contentAlignment = Alignment.Center // Centers the text
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}