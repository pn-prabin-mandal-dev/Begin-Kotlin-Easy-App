package com.example.gds.beginkotlineasy.features.extra_one

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.gds.beginkotlineasy.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Setting(navController: NavController = rememberNavController()) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        SettingContent()
    }
}

@Composable
fun SettingContent(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var clickSoundEnabled by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        SettingsSection(title = "User experience")
        SettingsToggleItem(title = "Click Sound", checked = clickSoundEnabled) {
            clickSoundEnabled = it
        }

        SettingsSection(title = "About us")
        SettingsItem(icon = R.drawable.link, title = "Visit our website", onClick = {
            openLink("https://www.example.com", context) // Replace with actual website URL
        })
        SettingsItem(icon = R.drawable.playstore, title = "Download more apps", onClick = {
            openLink("https://play.google.com/store/apps/dev?id=6945875796149230220", context)
        })
        SettingsItem(icon = R.drawable.share, title = "Share your experience", onClick = {
            shareApp(context)
        })

        SettingsSection(title = "Social media")
        SettingsItem(icon = R.drawable.linkedin, title = "LinkedIn", onClick = {
            openLink("https://www.linkedin.com", context) // Replace with actual LinkedIn URL
        })
        SettingsItem(icon = R.drawable.facebook, title = "Facebook", onClick = {
            openLink("https://www.facebook.com", context) // Replace with actual Facebook URL
        })
        SettingsItem(icon = R.drawable.instagram, title = "Instagram", onClick = {
            openLink("https://www.instagram.com", context) // Replace with actual Instagram URL
        })
        SettingsItem(icon = R.drawable.twitter, title = "Twitter", onClick = {
            openLink("https://www.twitter.com", context) // Replace with actual Twitter URL
        })

        SettingsSection(title = "App information")
        SettingsItem(
            icon = R.drawable.grid,
            title = "App version",
            subtitle = "1.1.11",
            isRightArrow = false
        )
        SettingsItem(
            icon = R.drawable.hash,
            title = "App version code",
            subtitle = "36",
            isRightArrow = false
        )

        SettingsSection(title = "Legal")
        SettingsItem(icon = R.drawable.privacy_policy, title = "Privacy Policy", onClick = {
            openLink(
                "https://www.example.com/privacy",
                context
            ) // Replace with actual Privacy Policy URL
        })
        SettingsItem(icon = R.drawable.terms, title = "Terms and Conditions", onClick = {
            openLink("https://www.example.com/terms", context) // Replace with actual Terms URL
        })
    }
}

fun openLink(url: String, context: Context) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(url)
    }
    context.startActivity(intent)
}

fun shareApp(context: Context) {
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "Check out this awesome app!")
        putExtra(
            Intent.EXTRA_TEXT,
            "Download 'Begin Kotlin Easy' from: https://play.google.com/store/apps/dev?id=6945875796149230220"
        )
    }
    context.startActivity(Intent.createChooser(shareIntent, "Share via"))
}

@Composable
fun SettingsSection(title: String) {
    Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(16.dp))
}

@Composable
fun SettingsToggleItem(title: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.vibrate),
            contentDescription = null,
            tint = Color(0xFF3B2464)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(title, fontSize = 16.sp, modifier = Modifier.weight(1f))
        Switch(
            checked = checked,
            onCheckedChange = { newValue ->
                onCheckedChange(newValue) // Update the parent state
                val isOn = if (checked) "On" else "OFF"
                Toast.makeText(context, "Sound: $isOn", Toast.LENGTH_SHORT).show()
            })
    }
}

@Composable
fun SettingsItem(
    icon: Int,
    title: String,
    subtitle: String? = null,
    onClick: () -> Unit = {},
    isRightArrow: Boolean = true,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color(0xFF3B2464),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, fontSize = 16.sp)
            subtitle?.let { Text(it, fontSize = 14.sp, color = Color.Gray) }
        }
        if (isRightArrow) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = null,
                tint = Color(0xFF3B2464),
                modifier = Modifier.size(16.dp)
            )
        }
    }
}