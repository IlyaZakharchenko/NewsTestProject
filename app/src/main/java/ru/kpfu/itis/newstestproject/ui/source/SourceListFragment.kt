package ru.kpfu.itis.newstestproject.ui.source

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import kotlinx.android.synthetic.main.fragment_source_list.*
import ru.kpfu.itis.newstestproject.R
import ru.kpfu.itis.newstestproject.base.BaseFragment
import ru.kpfu.itis.newstestproject.databinding.FragmentSourceListBinding
import ru.kpfu.itis.newstestproject.ui.main.FragmentHostActivity
import ru.kpfu.itis.newstestproject.ui.news.NewsListFragment

class SourceListFragment : BaseFragment() {

    private lateinit var binding: FragmentSourceListBinding

    private lateinit var viewModel: SourceListViewModel

    override val menu: Int?
        get() = R.menu.menu_fragment_host

    override val toolbarTitle: Int?
        get() = R.string.title_sources

    override val enableBackPressed: Boolean
        get() = false

    override val toolbar: Toolbar?
        get() = source_list_toolbar

    override val contentLayout: Int
        get() = R.layout.fragment_source_list


    companion object {

        fun newInstance() = SourceListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding = DataBindingUtil.setContentView(activity as FragmentHostActivity, contentLayout)
        binding.sourceList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this, factory).get(SourceListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel

    }

    fun openNewsListFragment(sourceId: String?) {
        (activity as? FragmentHostActivity)?.setFragment(NewsListFragment.newInstance(sourceId), true)
    }


    private fun showError(errorMessage: String) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }
}
