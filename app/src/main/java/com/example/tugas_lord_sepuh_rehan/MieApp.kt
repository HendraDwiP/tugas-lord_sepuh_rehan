package com.example.tugas_lord_sepuh_rehan

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.tugas_lord_sepuh_rehan.navigation.NavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.navigation.compose.NavHost
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugas_lord_sepuh_rehan.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MieApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: Screen.Home.route
    val currentScreen = remember(currentRoute) {
        Screen.fromRoute(currentRoute)
    }

    Scaffold(
        topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = {  navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = stringResource(id = R.string.menu_share)
                            )
                        }
                    },
                    title = { Text(text = currentScreen.title) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF82EEFD),
                    ),
                    //title = { Text(text = "currentScreen title") },
                )
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Home.route) {
                Home(navController)
            }

            composable(Screen.Koleksi.route) {
                Koleksi(navController)
            }

            composable(Screen.About.route) {
                About(navController)
            }

            composable(
                Screen.Detail.route + "/{masakanId}",
                arguments = listOf(navArgument("masakanId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                Detail(
                    navController = navController,
                    masakanId = navBackStackEntry.arguments?.getInt("masakanId")
                )
            }
        }
    }
}



@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_gallery),
                icon = Icons.Default.DateRange,
                screen = Screen.Koleksi
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_course),
                icon = Icons.Default.AccountBox,
                screen = Screen.About
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) }
            )
        }
    }
}