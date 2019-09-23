package com.mobile.ingcodecase.show.accounts.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.ingcodecase.core.presentation.recyclerview.DisplayItem
import com.mobile.ingcodecase.core.presentation.recyclerview.ViewHolder
import com.mobile.ingcodecase.core.presentation.recyclerview.ViewHolderBinder
import com.mobile.ingcodecase.core.presentation.recyclerview.ViewHolderFactory
import javax.inject.Inject

class SearchRepoViewHolder private constructor(itemView: View) :
    ViewHolder<SearchRepoViewEntity>(itemView) {

    private val textviewRepoName: TextView =
        itemView.findViewById(R.id.textViewRepoName)


    override fun bind(item: SearchRepoViewEntity) {

            textviewRepoName.text = item.name
    }

    internal class SearchRepoViewHolderFactory @Inject constructor() : ViewHolderFactory {
        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            SearchRepoViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_search_repo,
                    parent,
                    false
                )
            )


    }

    internal class SearchRepoViewHolderBinder @Inject constructor() : ViewHolderBinder {
        override fun bind(holder: RecyclerView.ViewHolder, item: DisplayItem) {
            (holder as SearchRepoViewHolder).bind(item as SearchRepoViewEntity)
        }

    }

}