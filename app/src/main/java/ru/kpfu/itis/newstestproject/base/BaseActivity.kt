package ru.kpfu.itis.newstestproject.base

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    protected abstract val layout: Int

    protected abstract val menu: Int?

    protected abstract val toolbarTitle: Int?

    protected abstract val enableBackPressed: Boolean

    protected abstract val toolbar: Toolbar?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        setToolbar(toolbar)
        setToolbarTitle(toolbarTitle)
        enableBackPressed(enableBackPressed)
    }

    fun enableBackPressed(enable: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(enable)
        supportActionBar?.setDisplayShowHomeEnabled(enable)
    }

    fun setToolbarTitle(title: Int?) {
        supportActionBar?.title = title?.let { getString(it) }
    }

    fun setToolbar(toolbar: Toolbar?) {
        setSupportActionBar(toolbar)
    }

    fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menu?.let {
            menuInflater.inflate(it, menu)
            return true
        }
        return false
    }
}