package com.talhafaki.nowplaying.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.talhafaki.domain.entity.NetworkMovie
import com.talhafaki.domain.usecase.NowPlayingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by tfakioglu on 12.December.2021
 */
class NowPlayingRepository @Inject constructor(
    private val nowPlayingUseCase: NowPlayingUseCase
) {

    fun nowPlaying(): Flow<PagingData<NetworkMovie>> {
        val config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
            prefetchDistance = 5
        )
        return Pager(config) {
            NowPlayingDataSource(
                nowPlayingUseCase = nowPlayingUseCase
            )
        }.flow
    }
}
