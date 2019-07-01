package ru.kpfu.itis.newstestproject.base

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.view.*
import dagger.android.support.DaggerFragment
import ru.kpfu.itis.newstestproject.ui.main.FragmentHostActivity
import ru.kpfu.itis.newstestproject.di.factory.DaggerViewModelFactory
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {

    protected abstract val contentLayout: Int

    protected abstract val menu: Int?

    protected abstract val toolbarTitle: Int?

    protected abstract val enableBackPressed: Boolean

    protected abstract val toolbar: Toolbar?

    @Inject
    lateinit var factory: DaggerViewModelFactory

    var errorSnackbar: Snackbar? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(contentLayout, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? FragmentHostActivity)?.setToolbar(toolbar)
        (activity as? FragmentHostActivity)?.setToolbarTitle(toolbarTitle)
        (activity as? FragmentHostActivity)?.enableBackPressed(enableBackPressed)

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        this.menu?.let { inflater?.inflate(it, menu) }
    }

    protected fun hideError() {
        errorSnackbar?.dismiss()
    }
}