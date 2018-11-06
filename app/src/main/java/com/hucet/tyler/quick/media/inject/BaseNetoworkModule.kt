package com.hucet.tyler.quick.media.inject

import android.content.Context
import com.hucet.tyler.quick.media.BuildConfig
import com.hucet.tyler.quick.media.api.KakaoApi
import com.hucet.tyler.quick.media.api.NaverApi
import com.hucet.tyler.quick.media.android.testing.utils.KakaoAuthorizationInterceptor
import com.hucet.tyler.quick.media.android.testing.utils.NaverAuthorizationInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [])
class BaseNetoworkModule {
    @Singleton
    @Provides
    fun provideServiceOkHttpClient(): OkHttpClient.Builder {
        val builer = OkHttpClient.Builder()
                .addLoggingIntercept()
                .setTimeouts()
        return builer
    }

    @Provides
    @Singleton
    fun provideKakaoApi(okHttpClient: OkHttpClient.Builder): KakaoApi {
        okHttpClient.addInterceptor(KakaoAuthorizationInterceptor())
        return Retrofit.Builder()
                .client(okHttpClient.build())
                .baseUrl(BuildConfig.KAKAO_BASE_URL)
                .build()
                .create(KakaoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNaverApi(okHttpClient: OkHttpClient.Builder): NaverApi {
        okHttpClient.addInterceptor(NaverAuthorizationInterceptor())
        return Retrofit.Builder()
                .client(okHttpClient.build())
                .baseUrl(BuildConfig.NAVER_BASE_URL)
                .build()
                .create(NaverApi::class.java)
    }
}

fun OkHttpClient.Builder.addLoggingIntercept(
        level: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY): OkHttpClient.Builder {
    if (BuildConfig.DEBUG) {
        val logging = HttpLoggingInterceptor()
        logging.level = level
        addInterceptor(logging)
    }
    return this
}

fun OkHttpClient.Builder.setTimeouts(milliSecond: Long = BuildConfig.NETWORK_TIMEOUT_MILLIS): OkHttpClient.Builder {
    connectTimeout(milliSecond, TimeUnit.MILLISECONDS)
    readTimeout(milliSecond, TimeUnit.MILLISECONDS)
    writeTimeout(milliSecond, TimeUnit.MILLISECONDS)
    return this
}