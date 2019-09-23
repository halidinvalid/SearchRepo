package com.mobile.ingcodecase.show.accounts.domain

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call

interface SearchRepoRepository {
    fun getSearchRepository(request: String): Observable<List<SearchRepoResponse.Repo>>
}