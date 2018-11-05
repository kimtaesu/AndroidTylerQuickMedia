package com.hucet.tyler.quick.media.feed

import com.hucet.tyler.quick.media.api.NaverApi
import com.hucet.tyler.quick.media.api.NaverRequest
import kr.co.irobo.finance.di.scopes.ModuleScope
import javax.inject.Inject

@ModuleScope
class NaverRemoteSource @Inject constructor(private val naverApi: NaverApi) {
    fun searchMedium(request: NaverRequest) {
        naverApi.searchImage(request)
    }
}