package com.hucet.tyler.quick.media.android.testing.utils

import com.hucet.tyler.quick.media.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class NaverAuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newReq = request.newBuilder()
                .addHeader("X-Naver-Client-Id", "${BuildConfig.NAVER_CLIENT_ID}")
                .addHeader("X-Naver-Client-Secret", "${BuildConfig.NAVER_CLIENT_SECRET}")
                .build()
        return chain.proceed(newReq)
    }
}