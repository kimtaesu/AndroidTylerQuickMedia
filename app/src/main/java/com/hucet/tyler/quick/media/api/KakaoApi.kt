package com.hucet.tyler.quick.media.api

import com.hucet.tyler.quick.media.model.KakaoImageResponse
import com.hucet.tyler.quick.media.model.KakaoVClipResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface KakaoApi {
    @GET("/v2/search/image")
    fun searchImage(@Body request: KakaoRequest): Single<Response<KakaoImageResponse>>

    @GET("/v2/search/vclip")
    fun searchVClip(@Body request: KakaoRequest): Single<Response<KakaoVClipResponse>>
}
