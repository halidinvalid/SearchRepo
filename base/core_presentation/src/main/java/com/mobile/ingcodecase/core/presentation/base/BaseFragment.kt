package com.mobile.ingcodecase.core.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mobile.ingcodecase.core.error.Error
import com.mobile.ingcodecase.core.presentation.BaseActivity
import com.mobile.ingcodecase.core.presentation.Constants
import com.mobile.ingcodecase.core.presentation.R
import com.mobile.ingcodecase.core.presentation.navigation.UiNavigation
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

abstract class BaseFragment : Fragment(), BaseView {
    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    @MenuRes
    open val menuRes = Constants.NO_RES

    @StringRes
    open val titleRes = Constants.NO_RES

    open val uiNavigation = UiNavigation.BACK


    override fun onAttach(context: Context?) {
        if (activity is HasSupportFragmentInjector) {
            AndroidSupportInjection.inject(this)
            onInjected()
        }
        super.onAttach(context)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(menuRes != Constants.NO_RES)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        if (menuRes != Constants.NO_RES) {
            inflater?.inflate(menuRes, menu)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutRes(), null, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initNavigation(uiNavigation)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (titleRes != Constants.NO_RES) {
            setActivityTitle(getString(titleRes))
        }
    }

    fun initNavigation(uiNavigation: UiNavigation) {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        when (uiNavigation) {
            UiNavigation.BACK -> {
                actionBar?.setDisplayHomeAsUpEnabled(true)
                actionBar?.setHomeButtonEnabled(true)
            }
            UiNavigation.ROOT -> {
                actionBar?.setDisplayHomeAsUpEnabled(false)
                actionBar?.setHomeButtonEnabled(false)
            }
        }
    }

    override fun onError(e: Error) {
        val message = when (e) {
            is Error.UnknownError -> getString(R.string.error_message_unknowon_error)
            is Error.BusinessError -> e.message
            is Error.ApiError -> e.message
        }
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    protected fun setActivityTitle(title: String) {
        if (activity is BaseActivity) {
            (activity as BaseActivity).setScreenTitle(title)
        }
    }


    fun getApplication() = activity?.application

    open fun initView() {
        // can be overridden
    }

    open fun onInjected() {
        // can be o
    }
}