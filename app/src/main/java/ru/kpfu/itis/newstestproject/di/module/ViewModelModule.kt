package ru.kpfu.itis.newstestproject.di.module

import dagger.Module
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.multibindings.IntoMap
import dagger.Binds
import ru.kpfu.itis.newstestproject.ui.news.NewsListModule
import ru.kpfu.itis.newstestproject.ui.news.NewsListViewModel
import ru.kpfu.itis.newstestproject.ui.news.NewsViewModel
import ru.kpfu.itis.newstestproject.ui.source.SourceListModule
import ru.kpfu.itis.newstestproject.ui.source.SourceListViewModel
import ru.kpfu.itis.newstestproject.ui.source.SourceViewModel
import ru.kpfu.itis.newstestproject.di.factory.DaggerViewModelFactory
import ru.kpfu.itis.newstestproject.utils.ViewModelKey


@Module(includes = [SourceListModule::class, NewsListModule::class])
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SourceListViewModel::class)
    abstract fun sourceListViewModel(sourceListViewModel: SourceListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SourceViewModel::class)
    abstract fun sourceViewModel(sourceViewModel: SourceViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewsListViewModel::class)
    abstract fun newsListViewModel(newsListViewModel: NewsListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun newsViewModel(newsViewModel: NewsViewModel): ViewModel
}