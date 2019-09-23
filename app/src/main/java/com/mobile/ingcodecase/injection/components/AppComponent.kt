package com.mobile.ingcodecase.injection.components

import com.mobile.ingcodecase.SearchRepoApp
import com.mobile.ingcodecase.injection.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        DomainModule::class,
        DataModule::class,
        ViewModelModule::class
    ]
)

interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: SearchRepoApp): Builder

        fun build(): AppComponent
    }

    fun inject(application: SearchRepoApp)
}