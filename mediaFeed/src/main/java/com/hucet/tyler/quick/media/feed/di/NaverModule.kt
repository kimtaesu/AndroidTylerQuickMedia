package com.hucet.tyler.quick.media.feed.di

import com.hucet.tyler.quick.media.BuildConfig
import com.hucet.tyler.quick.media.api.NaverApi
import com.hucet.tyler.quick.media.feed.KakaoAuthorizationInterceptor
import com.hucet.tyler.quick.media.feed.NaverAuthorizationInterceptor
import dagger.Module
import dagger.Provides
import kr.co.irobo.finance.di.scopes.ModuleScope
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module(includes = [])
class NaverModule {
    @Provides
    @ModuleScope
    fun provideNaverApi(okHttpClient: OkHttpClient.Builder): NaverApi {
        okHttpClient.addInterceptor(NaverAuthorizationInterceptor())
        return Retrofit.Builder()
                .client(okHttpClient.build())
                .baseUrl(BuildConfig.NAVER_BASE_URL)
                .build()
                .create(NaverApi::class.java)
    }
}