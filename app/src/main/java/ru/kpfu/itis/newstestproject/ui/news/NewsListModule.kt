package ru.kpfu.itis.newstestproject.ui.news

import dagger.Module
import dagger.Provides

@Module
class NewsListModule {

    @Provides
    fun provideSourceId(fragment: NewsListFragment): String? = fragment.getSourceId()

    @Provides
    fun provideNewsListAdapter(): NewsListAdapter = NewsListAdapter()
}