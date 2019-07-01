package ru.kpfu.itis.newstestproject.ui.news

import android.arch.lifecycle.MutableLiveData
import ru.kpfu.itis.newstestproject.base.BaseViewModel
import ru.kpfu.itis.newstestproject.data.model.Article
import javax.inject.Inject

class NewsViewModel @Inject constructor(): BaseViewModel() {

    private var title = MutableLiveData<String>()

    private var author = MutableLiveData<String>()

    private var description = MutableLiveData<String>()

    fun bind(article: Article) {
        title.value = article.title
        author.value = article.author
        description.value = article.description
    }

    fun getTitle():MutableLiveData<String> = title

    fun getAuthor():MutableLiveData<String> = author

    fun getDescription():MutableLiveData<String> = description
}