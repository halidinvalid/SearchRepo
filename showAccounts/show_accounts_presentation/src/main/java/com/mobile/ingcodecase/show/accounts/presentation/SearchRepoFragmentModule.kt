package com.mobile.ingcodecase.show.accounts.presentation

import com.raqun.movies.core.injection.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchRepoFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [SearchRepoPresentationModule::class])
    abstract fun contributeSearcRepoFragmentInjector(): SearchRepoFragment
}