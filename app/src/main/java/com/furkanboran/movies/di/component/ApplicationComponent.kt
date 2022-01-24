package com.furkanboran.movies.di.component

import com.furkanboran.movies.di.module.ActivityBuilderModule
import com.furkanboran.movies.di.module.ApplicationModule
import com.furkanboran.movies.di.module.NetworkModule
import com.furkanboran.movies.MoviesApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityBuilderModule::class, NetworkModule::class]
)

interface ApplicationComponent : AndroidInjector<MoviesApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MoviesApp>()
}