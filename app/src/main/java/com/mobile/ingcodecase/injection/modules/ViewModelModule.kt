package com.mobile.ingcodecase.injection.modules

import androidx.lifecycle.ViewModelProvider
import com.mobile.ingcodecase.core.presentation.viewmodel.VmFactory
import com.mobile.ingcodecase.show.accounts.presentation.SearchRepoViewModelModule
import dagger.Binds
import dagger.Module

@Module(includes = [SearchRepoViewModelModule::class])
internal abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(vmFactory: VmFactory): ViewModelProvider.Factory
}