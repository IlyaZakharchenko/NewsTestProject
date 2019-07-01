package ru.kpfu.itis.newstestproject.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.BaseAdapter
import io.reactivex.disposables.Disposable
import ru.kpfu.itis.newstestproject.data.model.Source
import ru.kpfu.itis.newstestproject.di.module.NetworkModule
import ru.kpfu.itis.newstestproject.ui.source.SourceListAdapter
import ru.kpfu.itis.newstestproject.ui.source.SourceListViewModel

abstract class BaseViewModel: ViewModel() {
    protected lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    protected fun onStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    protected fun onFinish() {
        loadingVisibility.value = View.GONE
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    protected fun onError(it: Throwable) {
        errorMessage.value = it.message
    }
}