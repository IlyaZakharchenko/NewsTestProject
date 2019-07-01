package ru.kpfu.itis.newstestproject.ui.news

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import dagger.Provides
import dagger.Reusable
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_news_list.*
import ru.kpfu.itis.newstestproject.R
import ru.kpfu.itis.newstestproject.base.BaseFragment
import ru.kpfu.itis.newstestproject.databinding.FragmentNewsListBinding
import ru.kpfu.itis.newstestproject.ui.main.FragmentHostActivity
import javax.inject.Inject

class NewsListFragment @Inject constructor(): BaseFragment() {

    private lateinit var binding: FragmentNewsListBinding

    private lateinit var viewModel: NewsListViewModel

    override val contentLayout: Int
        get() = R.layout.fragment_news_list

    override val menu: Int?
        get() = R.menu.menu_fragment_host

    override val toolbarTitle: Int?
        get() = R.string.title_news

    override val enableBackPressed: Boolean
        get() = true

    override val toolbar: Toolbar?
        get() = news_list_toolbar

    companion object {

        const val SOURCE = "source"
        fun newInstance(sourceId: String?): NewsListFragment {
            val args = Bundle()
            args.putString(SOURCE, sourceId)

            val fragment = NewsListFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DataBindingUtil.setContentView(activity as FragmentHostActivity, contentLayout)
        binding.newsList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this, factory).get(NewsListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel

    }

    private fun showError(errorMessage: String) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    fun getSourceId(): String? = arguments?.getString(SOURCE) ?: "none"
}