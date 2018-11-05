package com.hucet.tyler.quick.media.feed

import com.hucet.tyler.quick.media.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class KakaoAuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newReq = request.newBuilder()
                .addHeader("Authorization", "KakaoAK ${BuildConfig.KAKAO_API_KEY}")
                .build()
        return chain.proceed(newReq)
    }
}