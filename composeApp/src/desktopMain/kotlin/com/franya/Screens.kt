package com.franya

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screens(
    val label: String,
    val icon: ImageVector
) {
    HomeScreen(
        label = "Home",
        icon = Icons.Filled.Image
    ),
    ArchiveScreen(
        label = "Archive",
        icon = Icons.Filled.Archive
    ),
    SettingsScreen(
        label = "Settings",
        icon = Icons.Filled.Settings
    )
}
