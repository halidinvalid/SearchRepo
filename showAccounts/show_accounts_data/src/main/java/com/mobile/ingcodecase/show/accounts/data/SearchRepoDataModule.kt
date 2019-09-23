package com.mobile.ingcodecase.show.accounts.data

import com.mobile.ingcodecase.show.accounts.domain.SearchRepoResponse
import com.mobile.ingcodecase.core.data.source.DataSource
import com.mobile.ingcodecase.show.accounts.domain.SearchRepoRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class SearchRepoDataModule {

    @Provides
    @Singleton
    fun provideSearchRepoServices(retrofit: Retrofit): SearchRepoServices =
        retrofit.create(SearchRepoServices::class.java)

    @Provides
    @Singleton
    fun provideSearchRepoRemoteDataSource(searchRepoServices: SearchRepoServices): DataSource.RetrieveRemoteDataSource<String, SearchRepoResponse.Repo> =
        SearchRepoRemoteDataSource(searchRepoServices)

    @Provides
    @Singleton
    fun provideSearchRepoRepository(searchRepoRemoteDataSource: SearchRepoRemoteDataSource): SearchRepoRepository =
        SearchRepoRepositoryImp(searchRepoRemoteDataSource)
}