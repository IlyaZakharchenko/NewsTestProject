package ru.kpfu.itis.newstestproject.ui.source

import android.arch.lifecycle.MutableLiveData
import android.view.View
import ru.kpfu.itis.newstestproject.base.BaseViewModel
import ru.kpfu.itis.newstestproject.data.model.Source
import ru.kpfu.itis.newstestproject.utils.extension.getParentFragment
import javax.inject.Inject

class SourceViewModel @Inject constructor(): BaseViewModel() {

    private var name = MutableLiveData<String>()
    private var description = MutableLiveData<String>()
    private var id = MutableLiveData<String>()

    fun bind(source: Source) {
        name.value = source.name
        description.value = source.description
        id.value = source.id
    }

    fun getSourceName():MutableLiveData<String> = name

    fun getSourceDescription():MutableLiveData<String> = description

    fun openNews(view: View) {
        (view.getParentFragment() as? SourceListFragment)?.openNewsListFragment(id.value)
    }
}