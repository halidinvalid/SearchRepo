package com.mobile.ingcodecase.core.presentation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.mobile.ingcodecase.core.presentation.navigation.UiNavigation
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @LayoutRes
    abstract fun getLayoutRes(): Int

    @StringRes
    val titleRes = R.string.app_name

    @MenuRes
    open val menuRes = Constants.NO_RES

    open val uiNavigation = UiNavigation.BACK

    @IdRes
    open val toolbarRes = Constants.NO_RES

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        onInject()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        if (toolbarRes != Constants.NO_RES)
            setToolbar(findViewById(toolbarRes))

        initNavigation(uiNavigation)
        setScreenTitle(getString(titleRes))
    }

    fun setScreenTitle(title: String?) {
        supportActionBar?.title = title
    }

    fun initNavigation(uiNavigation: UiNavigation) {
        when (uiNavigation) {
            UiNavigation.BACK -> supportActionBar?.setDisplayHomeAsUpEnabled(true)
            UiNavigation.ROOT -> supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
    }

    fun setToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
    }

    open fun onInject() {
        // can be overridden
    }
}