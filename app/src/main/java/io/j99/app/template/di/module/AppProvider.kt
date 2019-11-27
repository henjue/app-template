package io.j99.app.template.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.j99.app.template.di.AppViewModelFactory
import io.j99.app.template.di.ViewModelKey

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.j99.app.template.ui.main.vm.HomePageViewModel


@Suppress("unused")
@Module
abstract class AppProvider {
    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @ViewModelKey(HomePageViewModel::class)
    @Binds
    internal abstract fun bindHomePageViewModel(pageViewModel: HomePageViewModel): ViewModel


}
