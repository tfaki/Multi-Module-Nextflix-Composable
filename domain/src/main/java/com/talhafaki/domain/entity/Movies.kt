package com.talhafaki.domain.entity

/**
 * Created by tfakioglu on 13.December.2021
 */
data class Movies(
    val movies: List<NetworkMovie>,
    val currentPage: Int,
    val totalPages: Int,
)