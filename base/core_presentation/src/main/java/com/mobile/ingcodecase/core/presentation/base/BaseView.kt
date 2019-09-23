package com.mobile.ingcodecase.core.presentation.base

import com.mobile.ingcodecase.core.error.Error


interface BaseView {
    fun onError(e: Error)
}