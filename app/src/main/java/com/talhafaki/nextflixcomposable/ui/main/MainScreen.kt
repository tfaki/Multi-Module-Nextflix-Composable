package com.talhafaki.nextflixcomposable.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.talhafaki.common.items.NavigationItem
import com.talhafaki.common.theme.SpeechRed
import com.talhafaki.nextflixcomposable.R
import com.talhafaki.nowplaying.NowPlayingScreen
import com.talhafaki.popular.PopularScreen
import com.talhafaki.upcoming.UpcomingScreen

/**
 * Created by tfakioglu on 12.December.2021
 */
@Composable
fun MainScreen() {
    SettingUpBottomNavigationBarAndCollapsing()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SettingUpBottomNavigationBarAndCollapsing() {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    Scaffold(modifier = Modifier,
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier
                    .height(56.dp),
                navController
            )
        }
    ) {
        MainScreenNavigationConfigurations(navController)
    }
}

@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController,
) {
    NavHost(navController, startDestination = NavigationItem.NowPlaying.route) {
        composable(NavigationItem.NowPlaying.route) {
            NowPlayingScreen()
        }
        composable(NavigationItem.Popular.route) {
            PopularScreen()
        }
        composable(NavigationItem.Upcoming.route) {
            UpcomingScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier, navController: NavController) {
    val bottomNavigationItems = listOf(
        NavigationItem.NowPlaying,
        NavigationItem.Popular,
        NavigationItem.Upcoming
    )
    BottomNavigation(
        modifier
            .graphicsLayer {
                shape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                )
                clip = true
            },
        backgroundColor = colorResource(id = R.color.black),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        bottomNavigationItems.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.route) },
                label = { Text(text = item.route) },
                selectedContentColor = SpeechRed,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }

                        /**
                         * As per https://developer.android.com/jetpack/compose/navigation#bottom-nav
                         * By using the saveState and restoreState flags,
                         * the state and back stack of that item is correctly saved
                         * and restored as you swap between bottom navigation items.
                         */

                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true

                        // Restore state when reselecting a previously selected item
                        restoreState = true

                    }
                }
            )
        }
    }
}
