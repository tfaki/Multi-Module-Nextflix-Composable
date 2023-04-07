package com.talhafaki.popular.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.talhafaki.common.items.NavigationItem
import com.talhafaki.popular.ui.PopularRoute

/**
 * Created by talhafaki on 23.03.2023.
 */

fun NavGraphBuilder.popularScreen() {
    composable(route = NavigationItem.Popular.route) {
        PopularRoute()
    }
}