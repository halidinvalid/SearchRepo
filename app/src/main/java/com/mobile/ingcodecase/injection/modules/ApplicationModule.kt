package com.mobile.ingcodecase.injection.modules

import android.content.Context
import com.mobile.ingcodecase.SearchRepoApp
import com.mobile.ingcodecase.core.injection.module.CoreModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [CoreModule::class]
)
class ApplicationModule {

    @Provides
    fun provideApplicationContext(app: SearchRepoApp): Context {
        return app.applicationContext
    }
}