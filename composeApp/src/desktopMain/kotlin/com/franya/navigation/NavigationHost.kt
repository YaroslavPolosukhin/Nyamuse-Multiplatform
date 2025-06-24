package com.franya.navigation

import androidx.compose.runtime.Composable
import com.franya.Screens
import com.franya.screens.ArchiveScreen
import com.franya.screens.HomeScreen
import com.franya.screens.SettingsScreen

class NavigationHost(
    val navController: NavController,
    val contents: @Composable NavigationGraphBuilder.() -> Unit
) {

    @Composable
    fun build() {
        NavigationGraphBuilder().renderContents()
    }

    inner class NavigationGraphBuilder(
        val navController: NavController = this@NavigationHost.navController
    ) {
        @Composable
        fun renderContents() {
            this@NavigationHost.contents(this)
        }
    }
}

@Composable
fun NavigationHost.NavigationGraphBuilder.composable(
    route: String,
    content: @Composable () -> Unit
) {
    if (navController.currentScreen.value == route) {
        content()
    }
}

@Composable
fun CustomNavigationHost(
    navController: NavController
) {
    NavigationHost(navController) {
        composable(Screens.HomeScreen.name) {
            HomeScreen(navController)
        }

        composable(Screens.ArchiveScreen.name) {
            ArchiveScreen(navController)
        }

        composable(Screens.SettingsScreen.name) {
            SettingsScreen(navController)
        }
    }.build()
}
