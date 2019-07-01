package ru.kpfu.itis.newstestproject.ui.main.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.kpfu.itis.newstestproject.ui.main.FragmentHostActivity
import ru.kpfu.itis.newstestproject.ui.main.FragmentHostModule

@Module
abstract class RootBuilder {
    @ContributesAndroidInjector(modules = [FragmentHostModule::class])
    abstract fun buildFragmentHostActivity(): FragmentHostActivity
}