package com.hucet.tyler.quick.media.feed.di

import dagger.BindsInstance
import dagger.Component
import kr.co.irobo.finance.di.scopes.ModuleScope

@ModuleScope
@Component(modules = [MediaFeedModule::class])
interface AboutComponent {

    fun inject(activity: AboutActivity)

    @Component.Builder
    interface Builder {

        fun build(): AboutComponent

        @BindsInstance
        fun activity(activity: AboutActivity): Builder

        fun aboutActivityModule(module: AboutActivityModule): Builder

        fun markdownModule(module: MarkdownModule): Builder
    }
}
