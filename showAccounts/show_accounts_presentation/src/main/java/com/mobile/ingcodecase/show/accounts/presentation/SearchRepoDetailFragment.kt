package com.mobile.ingcodecase.show.accounts.presentation

import android.os.Bundle
import com.mobile.ingcodecase.core.presentation.base.BaseFragment

class SearchRepoDetailFragment : BaseFragment() {

    override fun getLayoutRes(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    companion object {
        private const val BUNDLE_IMAGE_PATH = "image_path"
        private const val BUNDLE_STARS = "stars"
        private const val BUNDLE_REPO_NAME = "repo_name"
        private const val BUNDLE_OWNER = "owner"
        private const val BUNDLE_OPEN_ISSUES = "open_issues"

        fun newInstance(
            imagePath: String,
            stars: Int,
            repoName: String,
            owner: String,
            openIssues: Int
        ) = SearchRepoDetailFragment().apply {
            arguments = Bundle().apply {
                putString(BUNDLE_IMAGE_PATH, imagePath)
                putInt(BUNDLE_STARS, stars)
                putString(BUNDLE_REPO_NAME, repoName)
                putString(BUNDLE_OWNER, owner)
                putInt(BUNDLE_OPEN_ISSUES, openIssues)
            }
        }

    }
}