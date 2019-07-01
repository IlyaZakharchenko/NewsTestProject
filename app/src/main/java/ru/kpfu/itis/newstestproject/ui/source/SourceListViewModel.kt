package ru.kpfu.itis.newstestproject.ui.source

import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.kpfu.itis.newstestproject.base.BaseViewModel
import ru.kpfu.itis.newstestproject.data.api.NewsApi
import ru.kpfu.itis.newstestproject.data.model.Source
import javax.inject.Inject

class SourceListViewModel @Inject constructor(var api: NewsApi) : BaseViewModel() {

    @Inject
    lateinit var adapter: SourceListAdapter

    val errorClickListener = View.OnClickListener { loadSources() }

    init {
        loadSources()
    }

    private fun loadSources() {
        subscription = api.getSources()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onStart() }
            .doAfterTerminate { onFinish() }
            .map { it.sources }
            .subscribe(
                { result -> onSuccess(result) },
                { onError(it) })
    }

    private fun onSuccess(sourceList: List<Source>) {
        adapter.update(sourceList)
    }
}