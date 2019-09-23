package com.mobile.ingcodecase.show.accounts.domain

import com.mobile.ingcodecase.core.domain.Interactor
import io.reactivex.Observable
import javax.inject.Inject

class SearchRepoInteractor @Inject constructor(private val searchRepoRepository: SearchRepoRepository) :
    Interactor.ReactiveRetrieveInteractor<SearchRepoInteractor.SearchRepoInteractorParams, SearchRepoResponse.Repo> {

    override fun execute(params: SearchRepoInteractorParams): Observable<List<SearchRepoResponse.Repo>> {

        if (params.request == "")
            throw IllegalArgumentException("Invalid request param")
        return searchRepoRepository.getSearchRepository(params.request)
    }


    class SearchRepoInteractorParams(val request: String) :
        Interactor.Params()
}