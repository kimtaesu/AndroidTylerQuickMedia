package com.hucet.tyler.quick.media.feed.di

import com.hucet.tyler.quick.media.BuildConfig
import com.hucet.tyler.quick.media.api.KakaoApi
import com.hucet.tyler.quick.media.feed.KakaoAuthorizationInterceptor
import dagger.Module
import dagger.Provides
import kr.co.irobo.finance.di.scopes.ModuleScope
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module(includes = [])
class KakaoModule {
    @Provides
    @ModuleScope
    fun provideKakaoApi(okHttpClient: OkHttpClient.Builder): KakaoApi {
        okHttpClient.addInterceptor(KakaoAuthorizationInterceptor())
        return Retrofit.Builder()
                .client(okHttpClient.build())
                .baseUrl(BuildConfig.KAKAO_BASE_URL)
                .build()
                .create(KakaoApi::class.java)
    }
}

