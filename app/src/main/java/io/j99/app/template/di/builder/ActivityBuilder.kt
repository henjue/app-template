package io.j99.app.template.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.j99.app.template.ui.main.view.MainActivity

/**
 * 装载activity
 */
@Suppress("unused")
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityFragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity


}