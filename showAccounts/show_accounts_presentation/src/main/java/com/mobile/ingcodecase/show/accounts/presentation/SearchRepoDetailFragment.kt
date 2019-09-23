package com.mobile.ingcodecase.show.accounts.presentation

import android.os.Bundle
import com.mobile.ingcodecase.core.presentation.base.BaseFragment
import com.mobile.ingcodecase.core.presentation.extensions.loadImage
import kotlinx.android.synthetic.main.fragment_search_repo_details.*

class SearchRepoDetailFragment : BaseFragment() {

    private var imagePath: String? = null
    private var stars: Int = 0
    private var repoName: String? = null
    private var owner: String? = null
    private var openIssues: Int = 0

    override fun getLayoutRes() = R.layout.fragment_search_repo_details


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imagePath = arguments?.getString(BUNDLE_IMAGE_PATH).toString()
        stars = arguments?.getInt(BUNDLE_STARS)!!
        repoName = arguments?.getString(BUNDLE_REPO_NAME).toString()
        owner = arguments?.getString(BUNDLE_OWNER).toString()
        openIssues = arguments?.getInt(BUNDLE_OPEN_ISSUES)!!


    }


    override fun initView() {
        super.initView()


        if (imagePath.equals(""))
            imagePath = "https://miro.medium.com/max/560/1*MccriYX-ciBniUzRKAUsAw.png"

        imagePath?.let {
            imageViewProfile.loadImage(it)
        }
        textViewStars.text = stars.toString()
        textViewOpenIssues.text = openIssues.toString()
        textViewOwner.text = owner
        repoName?.let { setActivityTitle(it) }
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