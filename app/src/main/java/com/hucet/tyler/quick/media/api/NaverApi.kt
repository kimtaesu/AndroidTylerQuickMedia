package com.hucet.tyler.quick.media.api

import com.hucet.tyler.quick.media.model.KakaoImageResponse
import com.hucet.tyler.quick.media.model.NaverImageResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface NaverApi {
    @GET("/v1/search/image")
    fun searchImage(@Body request: NaverRequest): Single<Response<NaverImageResponse>>
}
