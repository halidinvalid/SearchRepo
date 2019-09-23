package com.mobile.ingcodecase.show.accounts.data

import com.mobile.ingcodecase.show.accounts.domain.SearchRepoResponse
import com.mobile.ingcodecase.core.data.source.DataSource
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import javax.inject.Inject
import retrofit2.Callback
import retrofit2.Response


class SearchRepoRemoteDataSource @Inject constructor(private val searchRepoServices: SearchRepoServices) :
    DataSource.RetrieveRemoteDataSource<String, SearchRepoResponse.Repo> {
    override fun getResult(request: String): Observable<List<SearchRepoResponse.Repo>> =
        searchRepoServices.reposForuser(request)
}