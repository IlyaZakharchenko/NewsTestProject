package ru.kpfu.itis.newstestproject.ui.main

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast
import ru.kpfu.itis.newstestproject.R
import ru.kpfu.itis.newstestproject.base.BaseActivity
import ru.kpfu.itis.newstestproject.base.BaseFragment
import ru.kpfu.itis.newstestproject.ui.news.NewsListFragment
import ru.kpfu.itis.newstestproject.ui.source.SourceListFragment
import javax.inject.Inject

class FragmentHostActivity : BaseActivity() {

    override val enableBackPressed: Boolean
        get() = false

    override val menu: Int?
        get() = null

    override val toolbarTitle: Int?
        get() = R.string.app_name

    override val toolbar: Toolbar?
        get() = null

    override val layout: Int
        get() = R.layout.activity_fragment_host

    fun setFragment(fragment: BaseFragment, addToBackStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        if (addToBackStack) {
            transaction.addToBackStack(fragment.javaClass.name)
        }
        transaction.replace(R.id.container, fragment, fragment.javaClass.name).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        openNewsListFragment()
        openSourceListFragment()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_favorite) {
            Toast.makeText(this, "Action clicked", Toast.LENGTH_LONG).show()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    fun openSourceListFragment() {
        setFragment(SourceListFragment.newInstance(), true)
    }

    fun openNewsListFragment() {
        setFragment(NewsListFragment.newInstance("abc-news"), true)
    }
}
