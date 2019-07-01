package ru.kpfu.itis.newstestproject.ui.source

import dagger.Module
import dagger.Provides
import ru.kpfu.itis.newstestproject.ui.source.SourceListAdapter


@Module
class SourceListModule {

    @Provides
    fun provideSourceListAdapter(): SourceListAdapter = SourceListAdapter()
}