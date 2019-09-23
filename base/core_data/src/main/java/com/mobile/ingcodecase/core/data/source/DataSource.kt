package com.mobile.ingcodecase.core.data.source

import io.reactivex.Observable

interface DataSource {
    interface RetrieveRemoteDataSource<Req, Res : Any> : DataSource {
        fun getResult(request: Req): Observable<List<Res>>
    }
}