package com.mobile.ingcodecase.show.accounts.domain

import com.google.gson.annotations.SerializedName

data class SearchRepoOwnerItem(
    @SerializedName("login")
    val loginOwner: String,
    @SerializedName("avatar_url")
    val profileImagePath: String
)