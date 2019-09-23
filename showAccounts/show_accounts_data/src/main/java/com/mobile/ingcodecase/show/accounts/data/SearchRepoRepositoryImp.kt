package com.mobile.ingcodecase.show.accounts.data

import com.mobile.ingcodecase.core.data.source.DataSource
import com.mobile.ingcodecase.show.accounts.domain.SearchRepoRepository
import com.mobile.ingcodecase.show.accounts.domain.SearchRepoResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import javax.inject.Inject

class SearchRepoRepositoryImp
@Inject constructor(private val searchRepoRemoteDataSource: DataSource.RetrieveRemoteDataSource<String, SearchRepoResponse.Repo>) :
    SearchRepoRepository {
    override fun getSearchRepository(request: String): Observable<List<SearchRepoResponse.Repo>> {
        return searchRepoRemoteDataSource.getResult(request)
    }

}