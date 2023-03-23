package com.talhafaki.nowplaying.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.talhafaki.common.items.NavigationItem
import com.talhafaki.nowplaying.NowPlayingRoute

/**
 * Created by talhafaki on 23.03.2023.
 */

fun NavGraphBuilder.nowPlayingScreen() {
    composable(route = NavigationItem.NowPlaying.route) {
        NowPlayingRoute()
    }
}