package com.hucet.tyler.quick.media.repository

import com.hucet.tyler.quick.media.api.KakaoApi
import com.hucet.tyler.quick.media.api.KakaoRequest
import com.hucet.tyler.quick.media.model.KakaoImageResponse
import com.hucet.tyler.quick.media.model.KakaoVClipResponse
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KakaoRemoteSource @Inject constructor(private val kakaoApi: KakaoApi) {
    fun searchImage(req: KakaoRequest): Single<Response<KakaoImageResponse>> =
            kakaoApi.searchImage(req)

    fun searchVClip(req: KakaoRequest): Single<Response<KakaoVClipResponse>> =
            kakaoApi.searchVClip(req)
}