package com.mobile.ingcodecase.injection.modules

import com.mobile.ingcodecase.core.data.module.ApiModule
import com.mobile.ingcodecase.show.accounts.data.SearchRepoDataModule
import dagger.Module

@Module(
    includes = [ApiModule::class,
        SearchRepoDataModule::class]
)
internal abstract class DataModule