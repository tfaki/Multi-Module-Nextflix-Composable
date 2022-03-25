package com.talhafaki.upcoming

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by tfakioglu on 12.December.2021
 */
@HiltViewModel
class UpcomingViewModel @Inject constructor(
    private val upcomingRepository: UpcomingRepository,
) : ViewModel() {

    val upcomingList = upcomingRepository.upcoming().cachedIn(viewModelScope)

}
