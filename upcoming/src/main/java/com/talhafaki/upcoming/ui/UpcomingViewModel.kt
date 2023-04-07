package com.talhafaki.upcoming.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.talhafaki.upcoming.data.UpcomingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by tfakioglu on 12.December.2021
 */
@HiltViewModel
class UpcomingViewModel @Inject constructor(
    upcomingRepository: UpcomingRepository,
) : ViewModel() {

    val upcomingList = upcomingRepository.upcoming().cachedIn(viewModelScope)

}
