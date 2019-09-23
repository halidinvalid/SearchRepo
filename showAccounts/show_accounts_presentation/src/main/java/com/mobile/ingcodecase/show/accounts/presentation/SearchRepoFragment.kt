package com.mobile.ingcodecase.show.accounts.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mobile.ingcodecase.core.model.DataHolder
import com.mobile.ingcodecase.core.presentation.base.BaseFragment
import com.mobile.ingcodecase.core.presentation.extensions.setup
import com.mobile.ingcodecase.core.presentation.recyclerview.DisplayItem
import com.mobile.ingcodecase.core.presentation.recyclerview.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_search_repo.*
import javax.inject.Inject

class SearchRepoFragment : BaseFragment() {

    @Inject
    protected lateinit var vmFactory: ViewModelProvider.Factory

    @Inject
    protected lateinit var searchRepoAdapter: RecyclerViewAdapter

    protected lateinit var viewModelSearchRepo: SearchRepoViewModel


    override fun getLayoutRes() = R.layout.fragment_search_repo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelSearchRepo =
            ViewModelProviders.of(this, vmFactory).get(SearchRepoViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewRepos.apply {
            setup(context = activity!!, adapter = searchRepoAdapter)

        }
        searchRepoAdapter.itemClickListener = this.itemClickListener
        buttonSubmit.setOnClickListener {
            if (editTextUserName.text.toString() == "")
                Toast.makeText(activity, "Username must not be empty", Toast.LENGTH_LONG).show()
            else
                viewModelSearchRepo.fetchSearchRepo(editTextUserName.text.toString())
        }
    }

    private val itemClickListener = { view: View, item: DisplayItem ->
        if (item is SearchRepoViewEntity) {
            activity?.supportFragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(
                R.id.framelayout_main,
                SearchRepoDetailFragment.newInstance(
                    item.owner.profileImagePath,
                    item.starCount,
                    item.name,
                    item.owner.loginOwner,
                    item.openIssuesCount
                )
            )?.commit()

        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelSearchRepo.searchRepoLiveData.observe(this, Observer {
            when (it) {
                is DataHolder.Success -> {
                    searchRepoAdapter.clearRecyclerView()
                    searchRepoAdapter.addItems(it.data)
                }
                is DataHolder.Fail -> onError(it.e)
                is DataHolder.Loading -> Log.e("loading", "search repo")
            }
        })
    }

    companion object {
        fun newInstance() = SearchRepoFragment()
    }

}