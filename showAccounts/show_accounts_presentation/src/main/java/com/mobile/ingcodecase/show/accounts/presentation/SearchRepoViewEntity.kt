package com.mobile.ingcodecase.show.accounts.presentation

import com.mobile.ingcodecase.core.presentation.entity.ViewEntity
import com.mobile.ingcodecase.core.presentation.recyclerview.DisplayItem

class SearchRepoViewEntity(
    val name: String
) : ViewEntity, DisplayItem {
    override fun type() = 0

}