package com.mobile.ingcodecase.injection.modules

import com.mobile.ingcodecase.show.accounts.domain.SearchRepoDomainModule
import dagger.Module

@Module(
    includes = [SearchRepoDomainModule::class]
)
internal abstract class DomainModule