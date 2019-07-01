package ru.kpfu.itis.newstestproject.ui.main

import dagger.Module
import ru.kpfu.itis.newstestproject.ui.main.builder.MainBuilder


@Module(includes = [MainBuilder::class])
class FragmentHostModule