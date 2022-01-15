package com.talhafaki.popular

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
class PopularViewModel @Inject constructor(
    private val popularRepository: PopularRepository
) : ViewModel() {

    fun getPopularList(): Flow<PagingData<NetworkMovie>> {
        return popularRepository.popular()
    }
}
