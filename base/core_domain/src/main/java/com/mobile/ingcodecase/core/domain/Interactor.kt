package com.mobile.ingcodecase.core.domain

import io.reactivex.Observable

interface Interactor {

    interface ReactiveRetrieveInteractor<P : Params, R : Any> : Interactor {
        fun execute(params: P): Observable<List<R>>
    }

    // marker class
    abstract class Params
}