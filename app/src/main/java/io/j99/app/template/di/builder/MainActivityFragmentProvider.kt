package io.j99.app.template.di.builder


import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.j99.app.template.ui.main.view.HomePageFragment

/**
 * activity对应的fragment
 * 如果该activity有fragment的话
 */
@Module
abstract class MainActivityFragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideHomePageFragment(): HomePageFragment
}