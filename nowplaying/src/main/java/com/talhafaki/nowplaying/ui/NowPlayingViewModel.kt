package com.talhafaki.nowplaying.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.talhafaki.nowplaying.data.NowPlayingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by tfakioglu on 12.December.2021
 */
@HiltViewModel
class NowPlayingViewModel @Inject constructor(
    nowPlayingRepository: NowPlayingRepository,
) : ViewModel() {

    val nowPlayingList = nowPlayingRepository.nowPlaying().cachedIn(viewModelScope)

}
