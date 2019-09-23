package com.mobile.ingcodecase.ui

import android.os.Bundle
import com.mobile.ingcodecase.R
import com.mobile.ingcodecase.core.presentation.BaseActivity
import com.mobile.ingcodecase.core.presentation.extensions.transact
import com.mobile.ingcodecase.core.presentation.navigation.UiNavigation
import com.mobile.ingcodecase.show.accounts.presentation.SearchRepoFragment

class MainActivity : BaseActivity() {

    override val uiNavigation = UiNavigation.ROOT

    override fun getLayoutRes() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.transact {
                replace(R.id.framelayout_main, SearchRepoFragment.newInstance())
            }
        }
    }
}
