package com.furkanboran.movies.di.module

import android.app.Application
import android.content.Context
import com.furkanboran.movies.MoviesApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(moviesApp: MoviesApp): Context = moviesApp.applicationContext

    @Provides
    @Singleton
    fun provideApplication(moviesApp: MoviesApp): Application = moviesApp
}