package com.talhafaki.nextflixcomposable.ui.popular

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.talhafaki.domain.entity.NetworkMovie
import com.talhafaki.domain.usecase.PopularUseCase
import com.talhafaki.nextflixcomposable.ui.popular.PopularDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by tfakioglu on 12.December.2021
 */
class PopularRepository @Inject constructor(
    private val popularUseCase: PopularUseCase
) {

    fun popular(): Flow<PagingData<NetworkMovie>> {
        val config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
            prefetchDistance = 5
        )
        return Pager(config) {
            PopularDataSource(
                popularUseCase = popularUseCase
            )
        }.flow
    }
}
