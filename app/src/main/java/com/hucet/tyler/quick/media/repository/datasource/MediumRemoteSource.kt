package com.hucet.tyler.quick.media.feed

import com.hucet.tyler.quick.media.repository.KakaoRemoteSource
import com.hucet.tyler.quick.media.repository.NaverRemoteSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MediumRemoteSource @Inject constructor(
        private val kakao: KakaoRemoteSource,
        private val naver: NaverRemoteSource) {
    fun searchMedium() {

    }
}