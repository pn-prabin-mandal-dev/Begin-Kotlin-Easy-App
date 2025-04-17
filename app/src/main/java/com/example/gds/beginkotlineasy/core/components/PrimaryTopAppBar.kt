package com.example.gds.beginkotlineasy.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gds.beginkotlineasy.R
import com.example.gds.beginkotlineasy.core.navigation.Routes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryTopAppBar(
    title: String = "Titile",
    navController: NavController = rememberNavController(),
    showBackIcon: Boolean,
    showActionIcon: Boolean
) {
    // Create the gradient Brush
    val gradientBrush = GradientPurple(
        startColor = colorResource(R.color.primary_color), // Start color
        endColor = colorResource(R.color.finalColor)  // End color
    )

    // Use Box to apply the background gradient
    Box(
        modifier = Modifier
            .background(gradientBrush), // Apply the gradient brush as background
    ) {
        // TopAppBar wrapped inside the Box
        TopAppBar(
            title = {
                Text(
                    text = title,
                    color = Color.LightGray // Set the title text color to Red
                )
            },
            navigationIcon = {
                if (showBackIcon) {
                    Box(modifier = Modifier.height(30.dp).width(40.dp).clickable{navController.popBackStack()}, contentAlignment = Alignment.Center,){
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.LightGray
                            )
                    }
                }
            },
            actions = {
                if (showActionIcon){
                    Box(modifier = Modifier.height(30.dp).width(40.dp).clickable{navController.navigate(
                        Routes.Setting)}, contentAlignment = Alignment.Center,){
                        Icon(
                            Icons.Default.Settings,
                            contentDescription = "Settings",
                            tint = Color.LightGray
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent), // Transparent to allow Box gradient
            modifier = Modifier
                .fillMaxWidth()
                .height(88.dp) // Ensure the TopAppBar spans the full width
        )
    }
}

@Composable
fun GradientPurple(
    startColor: Color = colorResource(R.color.primary_color),
    endColor: Color = colorResource(R.color.secondary_color).copy(0.6f),
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    title: String,
    showBackIcon: Boolean = false,
    onBackClick: () -> Unit = {},
    showActionIcon: Boolean = false,
    onActionClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier.height(64.dp), // Set a custom height for the TopAppBar
    ) {
        TopAppBar(
            modifier = Modifier
                .wrapContentHeight(Alignment.CenterVertically), // Vertically center the content
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF12D0EA), // Set the background color
                titleContentColor = Color.Black, // Set the title color
                navigationIconContentColor = Color.Black, // Set the navigation icon color
                actionIconContentColor = Color.Black // Set the action icon color
            ),
            navigationIcon = {
                if (showBackIcon) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Arrow Back"
                        )
                    }
                }
            },
            title = { Text(text = title) },
            actions = {
                if (showActionIcon) {
                    IconButton(
                        onClick = onActionClick
                    ) {
                        Icon(
                            Icons.Default.Settings,
                            contentDescription = "Setting Icon",
                        )
                    }
                }
            },
        )
    }
}
