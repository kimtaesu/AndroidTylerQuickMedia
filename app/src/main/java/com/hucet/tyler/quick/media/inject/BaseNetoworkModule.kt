package com.hucet.tyler.quick.media.inject

import android.content.Context
import com.hucet.tyler.quick.media.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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