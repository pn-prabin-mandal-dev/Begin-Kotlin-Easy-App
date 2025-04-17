package com.example.gds.beginkotlineasy.core.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gds.beginkotlineasy.R
import androidx.navigation.compose.rememberNavController
import com.example.gds.beginkotlineasy.core.navigation.Routes
import com.example.gds.beginkotlineasy.features.extra_one.ContentCardDataClass
import java.nio.file.WatchEvent

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeContentCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    cardContent: ContentCardDataClass = ContentCardDataClass("Tutorials", "104", "Topics",cardColor = colorResource(R.color.primary_dark), cardRoutes = Routes.InterviewQuestion)
) {
    val context = LocalContext.current
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier =Modifier
                .width(230.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(cardContent.cardColor.copy(0.6f))
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row {
                    Text(
                        text = cardContent.cardTitle,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White.copy(0.8f), // Add a text color
                            fontWeight = FontWeight.SemiBold
                        ),
                        modifier = Modifier.weight(6f)
                    )
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Arrow Right",
                        modifier = Modifier
                            .rotate(180f)
                            .weight(1f),
                        tint = Color.White.copy(0.8f)
                    )
                }

                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp), thickness = 2.dp,
                    color = Color.White.copy(0.8f)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = cardContent.contentNumber,
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.White.copy(0.8f), // Add a text color
                            fontWeight = FontWeight.Bold
                        ),
                    )

                    Text(
                        text = cardContent.trailingTitle,
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.White.copy(0.8f), // Add a text color
                            fontWeight = FontWeight.SemiBold
                        ),
                    )
                }

            }
        }
    }
}
