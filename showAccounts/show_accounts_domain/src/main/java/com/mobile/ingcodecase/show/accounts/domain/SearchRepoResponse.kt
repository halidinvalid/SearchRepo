package com.mobile.ingcodecase.show.accounts.domain

import com.google.gson.annotations.SerializedName

object SearchRepoResponse {
    data class Repo(
        @SerializedName("name")
        val name: String
    )
}