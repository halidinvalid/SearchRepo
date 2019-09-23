package com.mobile.ingcodecase.show.accounts.presentation

import com.raqun.movies.core.injection.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchRepoDetailFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeSearcRepoDetailFragmentInjector(): SearchRepoDetailFragment

}