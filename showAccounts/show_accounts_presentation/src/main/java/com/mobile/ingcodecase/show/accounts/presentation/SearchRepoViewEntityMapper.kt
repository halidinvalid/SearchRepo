package com.mobile.ingcodecase.show.accounts.presentation

import com.mobile.ingcodecase.core.presentation.recyclerview.DisplayItem
import com.mobile.ingcodecase.show.accounts.domain.SearchRepoResponse
import io.reactivex.functions.Function

class SearchRepoViewEntityMapper : Function<SearchRepoResponse.Repo, DisplayItem> {
    override fun apply(t: SearchRepoResponse.Repo): DisplayItem {
        return SearchRepoViewEntity(t.name)
    }

}