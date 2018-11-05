package com.hucet.tyler.quick.media.inject

import com.hucet.tyler.quick.media.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kr.co.irobo.finance.di.scopes.PerActivity

@Module
abstract class ActivityModule {
    @PerActivity
    @ContributesAndroidInjector(modules = [])
    internal abstract fun bindMainActivity(): MainActivity
}
