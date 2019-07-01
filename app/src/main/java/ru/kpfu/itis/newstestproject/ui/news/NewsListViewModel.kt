package ru.kpfu.itis.newstestproject.ui.news

import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.kpfu.itis.newstestproject.base.BaseViewModel
import ru.kpfu.itis.newstestproject.data.api.NewsApi
import ru.kpfu.itis.newstestproject.data.model.Article
import javax.inject.Inject

class NewsListViewModel @Inject constructor(var api: NewsApi, var sourceId: String?) : BaseViewModel() {

    @Inject
    lateinit var adapter: NewsListAdapter

    var errorClickListener = View.OnClickListener { loadNews() }

    init {
        loadNews()
    }

    private fun loadNews() {
        subscription = api.getNewsBySource(sourceId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onStart() }
            .doAfterTerminate { onFinish() }
            .map { it.articles }
            .subscribe(
                { result -> onSuccess(result) },
                { onError(it) }
            )
    }

    private fun onSuccess(articleList: List<Article>) {
        adapter.update(articleList)
    }
}