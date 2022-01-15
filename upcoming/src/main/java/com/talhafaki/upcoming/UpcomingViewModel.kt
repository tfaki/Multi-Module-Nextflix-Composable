package com.talhafaki.upcoming

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
class UpcomingViewModel @Inject constructor(
    private val upcomingRepository: UpcomingRepository
) : ViewModel() {

    fun upcomingList(): Flow<PagingData<NetworkMovie>> {
        return upcomingRepository.upcoming()
    }
}
