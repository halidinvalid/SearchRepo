package com.mobile.ingcodecase.core.injection.module

import com.mobile.ingcodecase.core.error.DefaultErrorFactory
import com.mobile.ingcodecase.core.error.ErrorFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class CoreModule {

    @Provides
    @Singleton
    internal fun provideErrorFactory(): ErrorFactory = DefaultErrorFactory()
}