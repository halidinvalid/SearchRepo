package com.mobile.ingcodecase.injection.modules

import com.mobile.ingcodecase.show.accounts.presentation.SearchRepoFragmentModule
import com.mobile.ingcodecase.ui.MainActivity
import com.raqun.movies.core.injection.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [SearchRepoFragmentModule::class])
    @ActivityScope
    abstract fun contributeMainActivityInjector(): MainActivity
}