package com.example.gds.beginkotlineasy.features.feature_program_syntax.presentation

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import com.example.gds.beginkotlineasy.R
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.gds.beginkotlineasy.features.feature_program_syntax.appliction_layer.ContentViewModel
import com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.model.ContentEntity

@Composable
fun ProgramAndSyntax(navController: NavController, contentViewModel: ContentViewModel, selected: Int= 0) {
    val isDataLoaded by contentViewModel.isDataLoaded.collectAsState()
    val context = LocalContext.current

    if (isDataLoaded) {
        var selectedTab by remember { mutableStateOf(selected) } // 0 = Programs, 1 = Syntax
        var selectedProgram by remember { mutableStateOf<ContentEntity?>(null) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(2.dp)) {
            // Add the TopAppBar as part of the content
            Column {

                // Call CustomAnimatedTabs correctly
                CustomAnimatedTabs(
                    selectedTab = selectedTab,
                    onTabSelected = { newTab -> selectedTab = newTab }
                )
            }

            // Rest of the content
            Box(modifier = Modifier.fillMaxSize()) {
                when (selectedTab) {
                    0 -> ProgramList(contentViewModel, { selectedProgram = it }) { title ->
                        copyToClipboard(context, title)
                    }

                    1 -> SyntaxList(contentViewModel, { selectedProgram = it }) { title ->
                        copyToClipboard(context, title)
                    }
                }
            }
        }
    }
        // Show program dialog when a program is selected
        selectedProgram?.let {
            ProgramDialog(
                it,
                onDismiss = { selectedProgram = null }
            )
        }
    } else {
        // Show a loading indicator while data is being loaded
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}


@Composable
fun CustomAnimatedTabs(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    val tabs = listOf("Programs", "Syntax")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp) // Fixed height for the main box
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Elevation for the main box
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            tabs.forEachIndexed { index, title ->
                // Animate background color
                val backgroundColor by animateColorAsState(
                    targetValue = if (selectedTab == index) colorResource(R.color.primary_color).copy(0.8f) else Color.White,
                    animationSpec = tween(durationMillis = 350) // Tween animation with 300ms duration
                )

                // Animate text color
                val textColor by animateColorAsState(
                    targetValue = if (selectedTab == index) Color.White else Color.Black,
                    animationSpec = tween(durationMillis = 300) // Tween animation with 300ms duration
                )

                Box(
                    modifier = Modifier
                        .weight(1f) // Equal width for both boxes
                        .fillMaxHeight()
                        .clickable { onTabSelected(index) }
                        .background(backgroundColor), // Animated background color
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        color = textColor, // Animated text color
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun ProgramList(
    viewModel: ContentViewModel,
    onProgramClick: (ContentEntity) -> Unit,
    onCopyTitle: (String) -> Unit,
) {
    val programData by viewModel.programData.collectAsState()

    // Group programs by their names
    val groupedPrograms = programData.groupBy { it.name }

    LazyColumn(modifier = Modifier.padding(16.dp)) {

        groupedPrograms.forEach { (name, programs) ->
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Display the group name as a header
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth() // Ensure the Row takes the full width
                    ) {
                        // First Divider
                        HorizontalDivider(
                            thickness = 1.dp,
                            modifier = Modifier.weight(1f), // Takes equal remaining space
                            color = MaterialTheme.colorScheme.primary
                        )

                        // Text
                        Text(
                            text = name,
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .wrapContentWidth() // Text takes width as per its content
                                .padding(horizontal = 8.dp) // Add some horizontal padding for spacing
                        )

                        // Second Divider
                        HorizontalDivider(
                            thickness = 1.dp,
                            modifier = Modifier.weight(1f), // Takes equal remaining space
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    // Display the cards in a row
                    // Display the cards in a row
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(programs) { program -> // Correct usage of items
                            ProgramCard(program, onProgramClick, onCopyTitle)
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp)) // Space between groups
                }
            }
        }
    }
}

@Composable
fun SyntaxList(
    viewModel: ContentViewModel,
    onSyntaxClick: (ContentEntity) -> Unit,
    onCopyTitle: (String) -> Unit,
) {
    val syntaxData by viewModel.syntaxData.collectAsState()

    // Group syntax items by their names
    val groupedSyntax = syntaxData.groupBy { it.name }

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        groupedSyntax.forEach { (name, syntaxItems) ->
            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    // Display the group name as a header
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth() // Ensure the Row takes the full width
                    ) {
                        // First Divider
                        HorizontalDivider(
                            thickness = 1.dp,
                            modifier = Modifier.weight(1f), // Takes equal remaining space
                            color = MaterialTheme.colorScheme.primary
                        )

                        // Text
                        Text(
                            text = name,
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .wrapContentWidth() // Text takes width as per its content
                                .padding(horizontal = 8.dp) // Add some horizontal padding for spacing
                        )

                        // Second Divider
                        HorizontalDivider(
                            thickness = 1.dp,
                            modifier = Modifier.weight(1f), // Takes equal remaining space
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    // Display the cards in a row
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp) // Space between cards
                    ) {
                        items(syntaxItems) { syntax ->
                            ProgramCard(syntax, onSyntaxClick, onCopyTitle)
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp)) // Space between groups
                }
            }
        }
    }
}

@Composable
fun ProgramCard(
    content: ContentEntity,
    onClick: (ContentEntity) -> Unit,
    onCopyTitle: (String) -> Unit,
) {
    val context = LocalContext.current

    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.initialColor).copy(0.8f),
            contentColor = Color.White.copy(0.8f)
        ),
        modifier = Modifier
            .width(225.dp) // Fixed width for each card
            .height(150.dp)
            .padding(vertical = 10.dp)
    ) {
        Column(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row {
                    Text(
                        content.title,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(8f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Image(
                        painter = painterResource(id = R.drawable.copy_icon),
                        contentDescription = "Copy Icon",
                        modifier = Modifier
                            .size(24.dp)
                            .weight(1.4f)
                            .clickable {
                                copyToClipboard(context, content.title)
                                onCopyTitle(content.title)
                            },
                        colorFilter = ColorFilter.tint(Color.White.copy(0.9f))
                    )
                }
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp),
                    color = Color.White.copy(0.6f)
                )

            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = { onClick(content) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black.copy(0.6f)
                )
            ) {
                Text("Show Details", color = colorResource(R.color.primary_color))
            }
        }
    }
}

@Composable
fun ProgramDialog(content: ContentEntity, onDismiss: () -> Unit) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    AlertDialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(dismissOnClickOutside = true),
        containerColor = Color(0xFF2A067C).copy(0.8f).compositeOver(Color.White), // Convert R.color to Compose Color
        titleContentColor = Color.White,
        shape = RoundedCornerShape(12.dp), // Rounded corners for the entire AlertDialog
        modifier = Modifier.height(320.dp),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Title
                Text(
                    text = content.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(3f)
                )
                // Copy Icon beside the title
                Icon(
                    painter = painterResource(id = R.drawable.copy_icon),
                    contentDescription = "Copy Icon",
                    tint = Color.White.copy(0.8f),
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            copyToClipboard(context, content.content, "Copied")
                        }
                        .padding(8.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    Icons.Rounded.Close,
                    contentDescription = "Close Icons",
                    modifier = Modifier
                        .clickable {
                            onDismiss()
                        }
                )
            }
        },
        text = {
            // Remember scroll states
            val verticalScrollState = rememberScrollState()
            val horizontalScrollState = rememberScrollState()

// Content Section with Line Numbers
            Box(
                modifier = Modifier
                    .height(260.dp) // Fixed size
                    .fillMaxWidth()
                    .background(Color.LightGray, shape = RoundedCornerShape(12.dp))
                    .clip(RoundedCornerShape(12.dp))
                    .padding(8.dp)
            ) {
                Row(modifier = Modifier.fillMaxSize()) {
                    // Line Numbers
                    Column(
                        modifier = Modifier
                            .verticalScroll(verticalScrollState) // Scroll vertically
                            .padding(end = 8.dp) // Spacing between numbers and text
                    ) {
                        val lines = content.content.split("\n")
                        lines.forEachIndexed { index, _ ->
                            Text(
                                text = "${index + 1}",
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }
                    }

                    // Scrollable Content
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .verticalScroll(verticalScrollState) // Vertical scroll
                            .horizontalScroll(horizontalScrollState) // Horizontal scroll
                    ) {
                        Text(
                            text = content.content,
                            color = Color.Black,
                            fontSize = 16.sp,
                            softWrap = false // Prevents text from wrapping
                        )
                    }
                }
            }

        },
        confirmButton = {
        },
        dismissButton = {}
    )
}

fun copyToClipboard(
    context: Context,
    text: String,
    message: String = "Copied",
) {  // note to its import
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Copied Text", text)
    clipboard.setPrimaryClip(clip)
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}