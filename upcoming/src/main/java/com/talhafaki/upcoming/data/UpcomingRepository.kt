package com.talhafaki.upcoming.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.talhafaki.domain.entity.NetworkMovie
import com.talhafaki.domain.usecase.UpcomingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by tfakioglu on 12.December.2021
 */
class UpcomingRepository @Inject constructor(
    private val upcomingUseCase: UpcomingUseCase
) {

    fun upcoming(): Flow<PagingData<NetworkMovie>> {
        val config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
            prefetchDistance = 5
        )
        return Pager(config) {
            UpcomingDataSource(
                upcomingUseCase = upcomingUseCase
            )
        }.flow
    }
}
