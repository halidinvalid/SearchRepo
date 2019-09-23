package com.mobile.ingcodecase.show.accounts.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.mobile.ingcodecase.core.domain.Interactor
import com.mobile.ingcodecase.core.error.ErrorFactory
import com.mobile.ingcodecase.core.model.DataHolder
import com.mobile.ingcodecase.core.presentation.recyclerview.DisplayItem
import com.mobile.ingcodecase.show.accounts.domain.SearchRepoInteractor
import com.mobile.ingcodecase.show.accounts.domain.SearchRepoResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchRepoViewModel @Inject constructor(
    private val searchRepoInteractor: Interactor.ReactiveRetrieveInteractor<SearchRepoInteractor.SearchRepoInteractorParams, SearchRepoResponse.Repo>,
    private val itemMapper: Function<SearchRepoResponse.Repo, DisplayItem>,
    private val errorFactory: ErrorFactory
) : ViewModel() {

    private val _searchRepoLiveData = MediatorLiveData<DataHolder<List<DisplayItem>>>()
    private val compositeDisposable = CompositeDisposable()
    private val searchRepoList = ArrayList<DisplayItem>()

    val searchRepoLiveData: LiveData<DataHolder<List<DisplayItem>>>
        get() = _searchRepoLiveData


    fun fetchSearchRepo(request: String) {
        _searchRepoLiveData.value = DataHolder.Loading()
        val searchRepoFetchDisposable =
            searchRepoInteractor.execute(SearchRepoInteractor.SearchRepoInteractorParams(request))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Observable.fromIterable(it)
                        .map { item -> itemMapper.apply(item) }
                        .toList()
                        .blockingGet()
                        .run {
                            _searchRepoLiveData.postValue(DataHolder.Success(this))
                            searchRepoList.addAll(this)
                        }

                }, {
                    _searchRepoLiveData.postValue(
                        DataHolder.Fail(
                            errorFactory.createErrorFromThrowable(
                                it
                            )
                        )
                    )
                })

        compositeDisposable.add(searchRepoFetchDisposable)

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}