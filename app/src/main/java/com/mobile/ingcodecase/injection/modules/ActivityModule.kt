package com.mobile.ingcodecase.injection.modules

import com.mobile.ingcodecase.show.accounts.presentation.SearchRepoActivity
import com.mobile.ingcodecase.show.accounts.presentation.SearchRepoDetailFragmentModule
import com.mobile.ingcodecase.show.accounts.presentation.SearchRepoFragmentModule
import com.raqun.movies.core.injection.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [SearchRepoFragmentModule::class, SearchRepoDetailFragmentModule::class])
    @ActivityScope
    abstract fun contributeMainActivityInjector(): SearchRepoActivity
}