package com.mobile.ingcodecase.show.accounts.domain

import com.google.gson.annotations.SerializedName

object SearchRepoResponse {
    data class Repo(
        @SerializedName("name")
        val name: String,
        @SerializedName("stargazers_count")
        val starCount: Int,
        @SerializedName("open_issues_count")
        val openIssuesCount: Int,
        @SerializedName("owner")
        val owner: SearchRepoOwnerItem

    )
}