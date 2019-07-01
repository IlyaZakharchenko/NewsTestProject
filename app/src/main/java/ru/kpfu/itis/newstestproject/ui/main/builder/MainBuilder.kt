package ru.kpfu.itis.newstestproject.ui.main.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.kpfu.itis.newstestproject.ui.news.NewsListFragment
import ru.kpfu.itis.newstestproject.ui.news.NewsListModule
import ru.kpfu.itis.newstestproject.ui.source.SourceListFragment
import ru.kpfu.itis.newstestproject.ui.source.SourceListModule

@Module
abstract class MainBuilder {

    @ContributesAndroidInjector(modules = [SourceListModule::class])
    abstract fun provideSourceListFragment(): SourceListFragment

    @ContributesAndroidInjector(modules = [NewsListModule::class])
    abstract fun provideNewsListFragment(): NewsListFragment
}