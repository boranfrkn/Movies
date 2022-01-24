package com.furkanboran.movies.di.module

import com.furkanboran.movies.di.scope.ActivityScope
import com.furkanboran.movies.features.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun mainActivity(): MainActivity
}