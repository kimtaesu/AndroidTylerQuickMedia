package com.hucet.tyler.quick.media.feed.di

import com.hucet.tyler.quick.media.BuildConfig
import com.hucet.tyler.quick.media.api.KakaoApi
import dagger.Module
import dagger.Provides
import kr.co.irobo.finance.di.scopes.ModuleScope
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module(includes = [KakaoModule::class, NaverModule::class])
class MediaFeedModule {

}