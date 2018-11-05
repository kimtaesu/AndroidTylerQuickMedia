package com.hucet.tyler.quick.media.feed

import kr.co.irobo.finance.di.scopes.ModuleScope
import javax.inject.Inject

@ModuleScope
class MediumRemoteSource @Inject constructor(
        private val kakao: KakaoRemoteSource,
        private val naver: NaverRemoteSource) {
    fun searchMedium() {

    }
}