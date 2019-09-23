package com.mobile.ingcodecase.show.accounts.domain

import com.mobile.ingcodecase.core.domain.Interactor
import dagger.Module
import dagger.Provides

@Module
class SearchRepoDomainModule {

    @Provides
    fun provideSearchRepoInteractor(searchRepoRepository: SearchRepoRepository):
            Interactor.ReactiveRetrieveInteractor<SearchRepoInteractor.SearchRepoInteractorParams, SearchRepoResponse.Repo> =
        SearchRepoInteractor(searchRepoRepository)
}