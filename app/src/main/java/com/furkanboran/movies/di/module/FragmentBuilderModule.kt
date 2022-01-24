package com.furkanboran.movies.di.module

import com.furkanboran.movies.di.scope.FragmentScope
import com.furkanboran.movies.features.home.ui.HomeFragment
import com.furkanboran.movies.features.movie_detail.MovieDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun movieDetailFragment(): MovieDetailFragment
}