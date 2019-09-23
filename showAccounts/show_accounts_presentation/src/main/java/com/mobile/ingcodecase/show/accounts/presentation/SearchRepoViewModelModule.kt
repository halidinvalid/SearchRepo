package com.mobile.ingcodecase.show.accounts.presentation

import androidx.lifecycle.ViewModel
import com.mobile.ingcodecase.core.presentation.recyclerview.DisplayItem
import com.mobile.ingcodecase.core.presentation.viewmodel.ViewModelKey
import com.mobile.ingcodecase.show.accounts.domain.SearchRepoResponse
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.functions.Function

@Module
abstract class SearchRepoViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SearchRepoViewModel::class)
    abstract fun bindSearchRepoViewModel(searchRepoViewModel: SearchRepoViewModel): ViewModel

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideSearchRepoViewEntityMapper(): Function<SearchRepoResponse.Repo, DisplayItem> =
            SearchRepoViewEntityMapper()
    }
}