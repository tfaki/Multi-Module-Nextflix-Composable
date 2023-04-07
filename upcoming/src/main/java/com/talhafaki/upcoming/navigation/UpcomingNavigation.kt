package com.talhafaki.upcoming.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.talhafaki.common.items.NavigationItem
import com.talhafaki.upcoming.ui.UpcomingRoute

/**
 * Created by talhafaki on 23.03.2023.
 */

fun NavGraphBuilder.upcomingScreen() {
    composable(route = NavigationItem.Upcoming.route) {
        UpcomingRoute()
    }
}