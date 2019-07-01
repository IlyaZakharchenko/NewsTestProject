package ru.kpfu.itis.newstestproject.utils.extension

import android.content.ContextWrapper
import android.view.View
import ru.kpfu.itis.newstestproject.R
import ru.kpfu.itis.newstestproject.base.BaseActivity
import ru.kpfu.itis.newstestproject.base.BaseFragment

fun View.getParentActivity(): BaseActivity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is BaseActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}

fun View.getParentFragment(): BaseFragment? = getParentActivity()?.supportFragmentManager?.findFragmentById(R.id.container) as BaseFragment