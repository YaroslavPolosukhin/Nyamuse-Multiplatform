package com.franya

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.franya.navigation.CustomNavigationHost
import com.franya.navigation.rememberNavController

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "nyamuse",
    ) {
        App()
    }
}

@Composable
fun App() {
    val screens = Screens.entries
    val navController by rememberNavController(Screens.HomeScreen.name)
    val currentScreen by remember {
        navController.currentScreen
    }

    MaterialTheme(
        colorScheme = darkColorScheme()
    ) {
        Surface(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
        ) {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 2.dp, vertical = 4.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    FilledTonalIconButton(
                        onClick = {

                        },
                        shape = RoundedCornerShape(20),
                        modifier = Modifier
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }

                    NavigationRail(
                        modifier = Modifier
                            .align(Alignment.End)
                    ) {
                        screens.forEach {
                            NavigationRailItem(
                                selected = currentScreen == it.name,
                                icon = {
                                    Icon(
                                        imageVector = it.icon,
                                        contentDescription = it.label
                                    )
                                },
                                label = {
                                    Text(it.label)
                                },
                                alwaysShowLabel = false,
                                onClick = {
                                    navController.navigate(it.name)
                                }
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier.fillMaxHeight()
                ) {
                    CustomNavigationHost(navController = navController)
                }
            }
        }
    }
}