package ru.kpfu.itis.newstestproject.di.factory

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.kpfu.itis.newstestproject.di.factory.DaggerViewModelFactory

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}