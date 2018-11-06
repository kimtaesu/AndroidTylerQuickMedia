package com.hucet.tyler.quick.media.repository

import com.hucet.tyler.quick.media.api.NaverApi
import com.hucet.tyler.quick.media.api.NaverRequest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NaverRemoteSource @Inject constructor(private val naverApi: NaverApi) {
    fun searchMedium(request: NaverRequest) {
        naverApi.searchImage(request)
    }
}