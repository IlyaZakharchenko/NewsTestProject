package ru.kpfu.itis.newstestproject.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.kpfu.itis.newstestproject.base.BaseApplication
import ru.kpfu.itis.newstestproject.di.module.ApplicationModule
import ru.kpfu.itis.newstestproject.di.module.NetworkModule
import ru.kpfu.itis.newstestproject.di.module.ViewModelModule
import ru.kpfu.itis.newstestproject.ui.main.builder.RootBuilder
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        RootBuilder::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseApplication>() {

        @BindsInstance
        abstract fun application(application: Application): Builder

    }
}