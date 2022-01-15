package com.talhafaki.nowplaying

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.talhafaki.domain.entity.NetworkMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by tfakioglu on 12.December.2021
 */
@HiltViewModel
class NowPlayingViewModel @Inject constructor(
    private val nowPlayingRepository: NowPlayingRepository
) : ViewModel() {

    fun nowPlayingList(): Flow<PagingData<NetworkMovie>> {
        return nowPlayingRepository.nowPlaying()
    }
}
