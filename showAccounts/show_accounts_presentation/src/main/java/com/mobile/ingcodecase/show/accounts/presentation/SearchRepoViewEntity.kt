package com.mobile.ingcodecase.show.accounts.presentation

import com.mobile.ingcodecase.core.presentation.entity.ViewEntity
import com.mobile.ingcodecase.core.presentation.recyclerview.DisplayItem
import com.mobile.ingcodecase.show.accounts.domain.SearchRepoOwnerItem

class SearchRepoViewEntity(
    val name: String,
    val starCount: Int,
    val openIssuesCount: Int,
    val owner: SearchRepoOwnerItem

) : ViewEntity, DisplayItem {
    override fun type() = 0

}