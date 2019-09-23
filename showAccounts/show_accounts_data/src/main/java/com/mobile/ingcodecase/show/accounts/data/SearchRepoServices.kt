package com.mobile.ingcodecase.show.accounts.data

import com.mobile.ingcodecase.show.accounts.domain.SearchRepoResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchRepoServices {
    @GET("/users/{user}/repos")
    fun reposForuser(@Path("user") user: String): Observable<List<SearchRepoResponse.Repo>>
}