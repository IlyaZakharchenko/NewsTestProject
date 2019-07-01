package ru.kpfu.itis.newstestproject.base

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import ru.kpfu.itis.newstestproject.di.component.DaggerAppComponent

class BaseApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<BaseApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .create(this)
    }
}