package com.mobile.ingcodecase.show.accounts.presentation

import com.mobile.ingcodecase.core.presentation.recyclerview.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntKey
import dagger.multibindings.IntoMap

@Module
abstract class SearchRepoPresentationModule {

    @Binds
    @IntoMap
    @IntKey(0)
    internal abstract fun bindSearchRepoViewHolderFactory(viewHolderFactory: SearchRepoViewHolder.SearchRepoViewHolderFactory): ViewHolderFactory

    @Binds
    @IntoMap
    @IntKey(0)
    internal abstract fun bindSearchRepoViewHolderBinder(viewHolderBinder: SearchRepoViewHolder.SearchRepoViewHolderBinder): ViewHolderBinder


    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideDisplayItemComperator(): DisplayItemComperator = DefaultDisplayItemComperator()

        @JvmStatic
        @Provides
        fun provideRecyclerAdapter(
            itemComparator: DisplayItemComperator,
            factoryMap: Map<Int, @JvmSuppressWildcards ViewHolderFactory>,
            binderMap: Map<Int, @JvmSuppressWildcards ViewHolderBinder>
        ): RecyclerViewAdapter {
            return RecyclerViewAdapter(
                itemComperator = itemComparator,
                viewHolderFactoryMap = factoryMap,
                viewBinderFactoryMap = binderMap
            )
        }
    }
}